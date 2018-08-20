from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer
from pybrain.structure.modules import SigmoidLayer

print('hello world')
with open('latencias_normalizado.txt') as f:
    lines = f.readlines()


ds = SupervisedDataSet(48, 1)

for input in lines:
    input = input.split(",")
    [float(i) for i in input if i != '']
    ds.addSample(input[1:], input[0])

train, test = ds.splitWithProportion(0.25)




nn = buildNetwork(48, 20, 1, bias=True, outclass = SigmoidLayer)
nn.reset()

trainer = BackpropTrainer(nn, train, learningrate=0.001)

training_errors, validation_errors = trainer.trainUntilConvergence()

print('erros de treino ------------------------------------------------------------')
for value in training_errors:
    #print(training_errors)
    print(value)
print('erros de validacao ----------------------------------------------------------')
for val in validation_errors:
    #print(training_errors)
    print(val)

#for i in xrange(3000):
 #   print(trainer.train())


#for inp, targ in test:
#    mytarg = nn.activate(inp)
  #  print(mytarg)
  # print(targ)

