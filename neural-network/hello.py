from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer


with open('latencias_completo.txt') as f:
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
print(trainer.trainUntilConvergence())

for inp, targ in test:
    mytarg = nn.activate(inp)
    print(mytarg - targ)
#print(nn.activate([774,1594,576,2187,536,422,370,343,485,1017,335,344,344,257,406,235,640,568,297,313,258,1000,483,266,453,1336,711,313,2188,1470,773,922,420,297,297,520,282,828,683,344,363,500,1172,305,422,641,816,844]))



