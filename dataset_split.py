import os
import re
import random
import shutil
import subprocess

def get_num(dir,verdict):
    num=0
    filenames = os.listdir(dir)
    for i in filenames:
        if i.endswith('.java') and verdict in i.split("@")[2]:
            num+=1
    return num


def is_bad_data(file):
    out=subprocess.Popen('java -cp JavaExtractor/JPredict/target/JavaExtractor-0.0.1-SNAPSHOT.jar JavaExtractor.App --max_path_length 8 --max_path_width 2 --file raw_dataset/' + file, stdout=subprocess.PIPE, stderr=subprocess.PIPE,shell=True)
    output=out.stdout.read()
    outlist=output.decode().split("\n")
    return len(outlist) != 2

if __name__ == '__main__':
    print(get_num("my_test_dir","OK"))
    print(get_num("my_test_dir","RUNTIME_ERROR"))
    print(get_num("my_val_dir", "OK"))
    print(get_num("my_val_dir", "RUNTIME_ERROR"))
    print(get_num("my_train_dir", "OK"))
    print(get_num("my_train_dir", "RUNTIME_ERROR"))
    # 定义路径
    source_dataset_path = 'raw_dataset'
    train_path = 'my_train_dir'
    val_path='my_val_dir'
    test_path = 'my_test_dir'

    # 读取source_dataset_path路径下所有文件（包括子文件夹下文件）
    filenames = os.listdir(source_dataset_path)

    defect_file = []
    no_defect_file=[]
    num=0
    for i in filenames:
        num+=1
        print(num)
        if is_bad_data(i):
            continue
        if i.endswith('.java') and "OK" in i.split("@")[2]:
            no_defect_file.append(i)
        else:
            defect_file.append(i)
    random.shuffle(defect_file)
    random.shuffle(no_defect_file)
    print(len(defect_file))
    print(len(no_defect_file))

    # 拆分写入
    for i in range(200):
        shutil.copyfile(f"raw_dataset/{defect_file[i]}", f"{train_path}/{defect_file[i]}")
    for i in range(200, 230):
        shutil.copyfile(f"raw_dataset/{defect_file[i]}", f"{val_path}/{defect_file[i]}")
    for i in range(230, 260):
        shutil.copyfile(f"raw_dataset/{defect_file[i]}", f"{test_path}/{defect_file[i]}")
    for i in range(800):
        shutil.copyfile(f"raw_dataset/{no_defect_file[i]}", f"{train_path}/{no_defect_file[i]}")
    for i in range(800, 920):
        shutil.copyfile(f"raw_dataset/{no_defect_file[i]}", f"{val_path}/{no_defect_file[i]}")
    for i in range(920, 1040):
        shutil.copyfile(f"raw_dataset/{no_defect_file[i]}", f"{test_path}/{no_defect_file[i]}")


