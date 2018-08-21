from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer
from pybrain.structure.modules import SigmoidLayer
from random import shuffle

print('hello world')
with open('latencias_normalizado.txt') as f:
    lines = f.readlines()


ds = SupervisedDataSet(48, 1)
for input in lines:
    input = input.split(",")
    [float(i) for i in input if i != '']
    ds.addSample(input[1:], input[0])

train, test = ds.splitWithProportion(0.25)




nn = buildNetwork(48, 10, 1, bias=True, outclass = SigmoidLayer)
nn.reset()

trainer = BackpropTrainer(nn, train, momentum=0.7)


for i in xrange(3000):
    print("%s %s" % (trainer.train(), i))

trainer.testOnData(test, verbose=True)
# for inp, targ in test:
#     mytarg = nn.activate(inp)
#     print(mytarg)
#     print(targ)

