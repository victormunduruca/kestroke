from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer


with open('latencias.txt') as f:
    lines = f.readlines()

for i in lines:
    print(i.split(","))