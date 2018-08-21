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

trainer = BackpropTrainer(nn, train)

training_errors, validation_errors = trainer.trainUntilConvergence()
j = 0
print('erros de treino ------------------------------------------------------------')
for value in training_errors:
    #print(training_errors)
    print("%s %s" % (value, j))
    j+=1
print('erros de validacao ----------------------------------------------------------')
k = 0
for val in validation_errors:
    #print(training_errors)
     print("%s %s" % (val, k))
     k+=1

#for i in xrange(3000):
 #   print(trainer.train())

print('Teste ----------------------------------------------------------')

trainer.testOnData(test, verbose=True)