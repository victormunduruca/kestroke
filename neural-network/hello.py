from pybrain.tools.shortcuts import buildNetwork
from pybrain.datasets import SupervisedDataSet
from pybrain.supervised.trainers import BackpropTrainer


#with open('Latencias.txt') as f:
 #   lines = f.readlines()


#ds = SupervisedDataSet(48, 1)


#ds.addSample((454,1828,593,219,297,304,344,218,344,579,375,265,187,188,218,313,224,391,416,586,281,1141,442,297,469,1014,210,797,510,421,526,750,318,266,297,375,226,531,531,266,188,546,293,219,203,172,156,27797), (27))
#ds.addSample((774,1594,576,2187,536,422,370,343,485,1017,335,344,344,257,406,235,640,568,297,313,258,1000,483,266,453,1336,711,313,2188,1470,773,922,420,297,297,520,282,828,683,344,363,500,1172,305,422,641,816,844), (41))

#for sample in lines:
  #  sample.split(",")
   # print(sample[0])
#print(lines[0])
#ds = SupervisedDataSet(48, 1)
#ds.addSample((312,125,516,193,94,203,110,140,125,125,266,312,78,63,234,250,263,187,610,139,156,500,234,70,266,125,109,63,234,125,90,297,110,187,422,120,235,125,203,281,94,51,765,266,146,78,125,13977), (19))

#for sample in lines:
 #   sample.split(",")
 #   print(sample[0])
#sample = lines[0]
#sample.split(",")
#ds.addSample((int(sample[1]), int(sample[2]), int(sample[3]), int(sample[4]), int(sample[5]), int(sample[6]), int(sample[7]), int(sample[8]), int(sample[9]), int(sample[10]), int(sample[11]), int(sample[12]), int(sample[13]), int(sample[14]), int(sample[15]), int(sample[16]), int(sample[17]), int(sample[18]), int(sample[19]), int(sample[20]), int(sample[21]), int(sample[22]), int(sample[23]), int(sample[24]), int(sample[25]), int(sample[26]), int(sample[27]), int(sample[28]), int(sample[29]), int(sample[30]), int(sample[31]), int(sample[32]), int(sample[33]), int(sample[34]), int(sample[35]), int(sample[36]), int(sample[37]), int(sample[38]), int(sample[39]), int(sample[40]), int(sample[41]), int(sample[42]), int(sample[43]), int(sample[44]), int(sample[45]), int(sample[46]), int(sample[47]), int(sample[48])), (int(sample[0]))
#len(ds)
#nn = buildNetwork(48, 4, 1, bias=True)

#trainer = BackpropTrainer(nn, ds)

#for i in xrange(2000):
 #   print(trainer.train())


#print(nn.activate([149,328,515,179,172,188,437,172,191,1922,322,250,172,172,144,188,156,156,172,328,173,219,828,165,500,157,1355,827,250,2276,2596,782,231,297,906,134,250,672,796,282,185,157,312,235,703,159,129,2687]))




ds = SupervisedDataSet(48,1)

tf = open('Latencias.txt','r')

for line in tf.readlines():
    data = [float(x) for x in line.strip().split(',') if x != '']
    indata =  tuple(data[1:])
    outdata = tuple(data[:48])
    ds.addSample(indata,outdata)

len(ds)