import random
from argparse import ArgumentParser
import common
import pickle
import subprocess
import time

'''
This script preprocesses the data from MethodPaths. It truncates methods with too many contexts,
and pads methods with less paths with spaces.
'''


def save_dictionaries(dataset_name, word_to_count, path_to_count, target_to_count,
                      num_training_examples):
    save_dict_file_path = '{}.dict.c2v'.format(dataset_name)
    with open(save_dict_file_path, 'wb') as file:
        pickle.dump(word_to_count, file)
        pickle.dump(path_to_count, file)
        pickle.dump(target_to_count, file)
        pickle.dump(num_training_examples, file)
        print('Dictionaries saved to: {}'.format(save_dict_file_path))

 
def process_file(file_path, data_file_role, dataset_name, word_to_count, path_to_count, max_contexts):
    sum_total = 0
    sum_sampled = 0
    total = 0
    empty = 0
    max_unfiltered = 0
    output_path = '{}.{}.c2v'.format(dataset_name, data_file_role)
    with open(output_path, 'w') as outfile:
        with open(file_path, 'r') as file:
            for line in file:
                parts = line.rstrip('\n').split(' ')
                target_name = parts[0]
                contexts = parts[1:]

                if len(contexts) > max_unfiltered:
                    max_unfiltered = len(contexts)
                sum_total += len(contexts)

                if len(contexts) > max_contexts:
                    context_parts = [c.split(',') for c in contexts]
                    full_found_contexts = [c for i, c in enumerate(contexts)
                                           if context_full_found(context_parts[i], word_to_count, path_to_count)]
                    partial_found_contexts = [c for i, c in enumerate(contexts)
                                              if context_partial_found(context_parts[i], word_to_count, path_to_count)
                                              and not context_full_found(context_parts[i], word_to_count,
                                                                         path_to_count)]
                    if len(full_found_contexts) > max_contexts:
                        contexts = random.sample(full_found_contexts, max_contexts)
                    elif len(full_found_contexts) <= max_contexts \
                            and len(full_found_contexts) + len(partial_found_contexts) > max_contexts:
                        contexts = full_found_contexts + \
                                   random.sample(partial_found_contexts, max_contexts - len(full_found_contexts))
                    else:
                        contexts = full_found_contexts + partial_found_contexts

                if len(contexts) == 0:
                    empty += 1
                    continue
# 对一个代码段的contexts进行随机欠采样后的context数目
                sum_sampled += len(contexts)

                csv_padding = " " * (max_contexts - len(contexts))
                outfile.write(target_name + ' ' + " ".join(contexts) + csv_padding + '\n')
                total += 1

    print('File: ' + data_file_path)
    print('Average total contexts: ' + str(float(sum_total) / total))
    print('Average final (after sampling) contexts: ' + str(float(sum_sampled) / total))
    print('Total examples: ' + str(total))
    print('Empty examples: ' + str(empty))
    print('Max number of contexts per word: ' + str(max_unfiltered))
    return total

# 返回bool类型值判断一个context中的word-path-word是否都出现在字典中
def context_full_found(context_parts, word_to_count, path_to_count):
    return context_parts[0] in word_to_count \
           and context_parts[1] in path_to_count and context_parts[2] in word_to_count


def context_partial_found(context_parts, word_to_count, path_to_count):
    return context_parts[0] in word_to_count \
           or context_parts[1] in path_to_count or context_parts[2] in word_to_count

# 生成raw和histogram文件
def extract_dataset(DATASET_NAME, TRAIN_DIR, TEST_DIR, VAL_DIR, train_data_path, test_data_path, val_data_path, word_histogram_path, path_histogram_path, target_histogram_path, max_path_length="8", max_path_width="2", num_threads="64",EXTRACTOR_JAR="JavaExtractor/JPredict/target/JavaExtractor-0.0.1-SNAPSHOT.jar"):
    subprocess.Popen("mkdir -p data", shell=True)
    subprocess.Popen(f"mkdir -p data/{DATASET_NAME}", shell=True)
    print("Extracting paths from validation set...")
    subprocess.Popen(f"python JavaExtractor/extract.py --dir {VAL_DIR} --max_path_length {max_path_length} --max_path_width {max_path_width} --num_threads {num_threads} --jar {EXTRACTOR_JAR} > {val_data_path}", shell=True)
    print("Finished extracting paths from test set")
    print("Extracting paths from validation set...")
    subprocess.Popen(f"python JavaExtractor/extract.py --dir {TEST_DIR} --max_path_length {max_path_length} --max_path_width {max_path_width} --num_threads {num_threads} --jar {EXTRACTOR_JAR} > {test_data_path}", shell=True)
    print("Finished extracting paths from test set")
    print("Extracting paths from training set...")
    subprocess.Popen(f"python JavaExtractor/extract.py --dir {TRAIN_DIR} --max_path_length {max_path_length} --max_path_width {max_path_width} --num_threads {num_threads} --jar {EXTRACTOR_JAR} | shuf > {train_data_path}", shell=True)
    print("Finished extracting paths from training set")

    time.sleep(1)

    subprocess.Popen(f"cat {train_data_path} | cut -d' ' -f1 | awk '{{n[$0]++}} END {{for (i in n) print i,n[i]}}' > {target_histogram_path}", shell=True)
    subprocess.Popen(f"cat {train_data_path} | cut -d' ' -f2- | tr ' ' '\n' | cut -d',' -f1,3 | tr ',' '\n' | awk '{{n[$0]++}} END {{for (i in n) print i,n[i]}}' > {word_histogram_path}", shell=True)
    subprocess.Popen(f"cat {train_data_path} | cut -d' ' -f2- | tr ' ' '\n' | cut -d',' -f2 | awk '{{n[$0]++}} END {{for (i in n) print i,n[i]}}' > {path_histogram_path}", shell=True)

    time.sleep(1)

if __name__ == '__main__':
    '''
    parser = ArgumentParser()
    parser.add_argument("-trd", "--train_data", dest="train_data_path",
                        help="path to training data file", required=True)
    parser.add_argument("-ted", "--test_data", dest="test_data_path",
                        help="path to test data file", required=True)
    parser.add_argument("-vd", "--val_data", dest="val_data_path",
                        help="path to validation data file", required=True)
    parser.add_argument("-mc", "--max_contexts", dest="max_contexts", default=200,
                        help="number of max contexts to keep", required=False)
    parser.add_argument("-wvs", "--word_vocab_size", dest="word_vocab_size", default=1301136,
                        help="Max number of origin word in to keep in the vocabulary", required=False)
    parser.add_argument("-pvs", "--path_vocab_size", dest="path_vocab_size", default=911417,
                        help="Max number of paths to keep in the vocabulary", required=False)
    parser.add_argument("-tvs", "--target_vocab_size", dest="target_vocab_size", default=261245,
                        help="Max number of target words to keep in the vocabulary", required=False)
    parser.add_argument("-wh", "--word_histogram", dest="word_histogram",
                        help="word histogram file", metavar="FILE", required=True)
    parser.add_argument("-ph", "--path_histogram", dest="path_histogram",
                        help="path_histogram file", metavar="FILE", required=True)
    parser.add_argument("-th", "--target_histogram", dest="target_histogram",
                        help="target histogram file", metavar="FILE", required=True)
    parser.add_argument("-o", "--output_name", dest="output_name",
                        help="output name - the base name for the created dataset", metavar="FILE", required=True,
                        default='data')
    args = parser.parse_args()
    '''
    TRAIN_DIR = "my_train_dir"
    VAL_DIR = "my_val_dir"
    TEST_DIR = "my_test_dir"
    DATASET_NAME = "my_dataset"
    MAX_CONTEXTS = 200
    WORD_VOCAB_SIZE = 1301136
    PATH_VOCAB_SIZE = 911417
    TARGET_VOCAB_SIZE = 261245
    NUM_THREADS = 64
    EXTRACTOR_JAR="JavaExtractor/JPredict/target/JavaExtractor-0.0.1-SNAPSHOT.jar"
    PYTHON = "python3"
    train_data_path = DATASET_NAME+".train.raw.txt"
    test_data_path = DATASET_NAME+".test.raw.txt"
    val_data_path = DATASET_NAME+".val.raw.txt"
    word_histogram_path = "data/"+DATASET_NAME+"/"+DATASET_NAME+".histo.ori.c2v"
    path_histogram_path = "data/"+DATASET_NAME+"/"+DATASET_NAME+".histo.path.c2v"
    target_histogram_path = "data/"+DATASET_NAME+"/"+DATASET_NAME+".histo.tgt.c2v"
    output_name = "data/"+DATASET_NAME+"/"+DATASET_NAME

    #extract_dataset(DATASET_NAME, TRAIN_DIR, TEST_DIR, VAL_DIR, train_data_path, test_data_path, val_data_path, word_histogram_path, path_histogram_path, target_histogram_path)

    # 以下的操作代码段都是训练集
    # 返回word_to_index, index_to_word, next_index,和word_to_count 最后只要word_to_count（其实就是对my_dataset.histo.ori进行处理后的版本），如果训练集的总word超过max_size,则会对word的count进行排序 舍弃count值小的
    word_histogram_data = common.common.load_vocab_from_histogram(word_histogram_path, start_from=1,
                                                                  max_size=int(WORD_VOCAB_SIZE),
                                                                  return_counts=True)
    _, _, _, word_to_count = word_histogram_data
    # 以下同理处理path和target（函数名）
    _, _, _, path_to_count = common.common.load_vocab_from_histogram(path_histogram_path, start_from=1,
                                                                     max_size=int(PATH_VOCAB_SIZE),
                                                                     return_counts=True)
    _, _, _, target_to_count = common.common.load_vocab_from_histogram(target_histogram_path, start_from=1,
                                                                       max_size=int(TARGET_VOCAB_SIZE),
                                                                       return_counts=True)

    num_training_examples = 0
    # 对测试集、验证集、训练集对应的raw文件的每一行进行读取，比较context和max_context大小关系来决定是否对context进行欠采样，从而限制每个代码段的context的数目
    for data_file_path, data_role in zip([test_data_path, val_data_path, train_data_path], ['test', 'val', 'train']):
        num_examples = process_file(file_path=data_file_path, data_file_role=data_role, dataset_name=output_name,
                                    word_to_count=word_to_count, path_to_count=path_to_count,
                                    max_contexts=int(MAX_CONTEXTS))
        if data_role == 'train':
            num_training_examples = num_examples
    # 对 word_to_count、path_to_count、target_to_count、训练集数目进行保存
    save_dictionaries(dataset_name=output_name, word_to_count=word_to_count,
                      path_to_count=path_to_count, target_to_count=target_to_count,
                      num_training_examples=num_training_examples)
