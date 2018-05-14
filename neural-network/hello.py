from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer



with open('latencias_normalizado.txt') as f:
    lines = f.readlines()


ds = SupervisedDataSet(48, 1)

for input in lines:
     input = input.split(",")
     [float(i) for i in input if i != '']
     ds.addSample(input[1:], input[0])

train, test = ds.splitWithProportion(0.25)


nn = buildNetwork(48, 1, 1, bias=True)


print(nn)
trainer = BackpropTrainer(nn, train, learningrate=0.001)
#print(trainer.trainUntilConvergence())

for i in xrange(1000):
    print(trainer.train())

for inp, targ in test:
     mytarg = nn.activate(inp)
     print(mytarg)
     print(targ)
     print()



