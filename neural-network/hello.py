from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer


with open('Latencias.txt') as f:
    lines = f.readlines()


ds = SupervisedDataSet(48, 1)

for input in lines:
    input = input.split(",")
    [float(i) for i in input if i != '']
    print(input[0])
    ds.addSample(input[1:], input[0])

print(len(ds))


nn = buildNetwork(48, 4, 1, bias=True)
print(nn)
trainer = BackpropTrainer(nn, ds)
trainer.trainUntilConvergence()


print(nn.activate([149,328,515,179,172,188,437,172,191,1922,322,250,172,172,144,188,156,156,172,328,173,219,828,165,500,157,1355,827,250,2276,2596,782,231,297,906,134,250,672,796,282,185,157,312,235,703,159,129,2687]))



