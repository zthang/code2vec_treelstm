import re
import csv
import json
import subprocess
import random

# 478个有问题 2410个没问题 404有完整堆栈信息 390左右能追踪在代码文件的哪行出问题 261个负样本 23494个正样本（除去main方法) 259 23303除去脏数据 预计划分：训练集200:800 验证集29:116 测试集30:120


def getNum(verdict):
    with open('graph.csv', 'r') as f:
        num = 0
        for submission in csv.DictReader(f):
            if submission['verdict'] == verdict and submission["language"]=="Java 8":
                num+=1
    print(f"{verdict}:{num}")


# mainClassName 主类名，method_signature 堆栈信息中括号里行数:前的那个类名(可为内部类Main$innerClass 所以用in) 若不等于主类名，则为java类库
def isLibFunction(mainClassName,method_signature):
    return mainClassName not in method_signature


def get_method_by_signature(code,methods, error_class, error_method, error_position):
    for method in methods:
        if method["methodName"]==error_method and int(error_position)<=method["endLine"] and int(error_position)>=method["beginLine"]:
            code_lines=code.split("\n")
            method_lines=code_lines[method["beginLine"]-1:method["endLine"]]
            method_code="\n".join(method_lines)
            return method_code,int(error_position)-method["beginLine"]+1


def parse_javacode(code):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    file_name = "".join(random.sample(alphabet, 16))+".txt"
    with open(file_name, "w") as file:
        file.write(code)
    out=subprocess.Popen("java -jar javaparser.jar "+file_name,stdout=subprocess.PIPE,shell=True).stdout
    res=json.loads(out.read())
    return res


# 初始化数组
method_level_dataset = []
with open('graph.csv', 'r') as f:
    # 第一趟循环：生成具有缺陷倾向性（defective）方法的样本
    num = 0
    print("开始生成有缺陷文件")
    for submission in csv.DictReader(f):
        num+=1
        print(num)
        # 只关注结果为RTE的提交
        if submission['verdict'] == 'OK' or submission["language"]=="Python 3":
            continue
        outputDic = json.loads(submission['outputs'])
        output_len = len(outputDic)
        last_output = outputDic['output#%s' % output_len]
        error_logs = last_output.split("\tat ")
        if len(error_logs) < 2:
            continue
        # 通过正则提取出堆栈信息中方法的签名 eg:at a.b.foo(Demo.java:11)
        for error in error_logs[1:]:
            temp_class=error.split("(")  # ["a.b.foo","Demo.java:11)"]
            if len(temp_class)>1:
                temp_method=temp_class[0].split(".")  # ["a","b","foo"]
                if len(temp_method)>1:
                    temp_position=temp_class[1].split(":")  # ["Demo.java","11)"]
                    if len(temp_position)>1:
                        flag=False
                        error_class = temp_class[0].replace(f".{temp_method[-1]}","")  # "a.b"
                        error_method = temp_method[-1]  # "foo"
                        error_position = temp_position[1].strip()[:-1]  # "11"
                        if error_method in ["main","<init>"] or "lambda" in error_method:
                            continue
                        res=parse_javacode(submission["source_code"])
                        if isLibFunction(res["mainClass"],temp_position[0].replace(".java","").strip()):  # 传入的第二个参数类似于上例中的Demo
                            continue
                        else:
                            method,line = get_method_by_signature(submission["source_code"],res["methods"], error_class, error_method, error_position)
                            if method is not None:
                                method_level_dataset.append([f"{submission['submission_id']}@{error_method}@{submission['verdict']}@{line}.java",method])
                                break
    print(f"缺陷文件数目:{len(method_level_dataset)}")
    num = 0
with open('graph.csv', 'r') as f:
    print("开始生成无缺陷文件")
    for submission in csv.DictReader(f):
        num += 1
        print(num)
        if submission['verdict'] == 'RUNTIME_ERROR' or submission["language"] == "Python 3":
            continue
        res = parse_javacode(submission["source_code"])

        methods = res["methods"]
        for method in methods:
            if method["methodName"] != "main":
                method_level_dataset.append([f"{submission['submission_id']}@{method['methodName']}@{submission['verdict']}.java", method["body"]])
    print("开始写入文件到数据集中")
    num=0
    for data in method_level_dataset:
        with open(f"raw_dataset/{data[0]}", "w") as file:
            file.write(data[1])
        num+=1
        print(f"写入第{num}个文件完成", flush=True)
    print(f"写入结束，共计生成{len(method_level_dataset)}个文件")
