#!/bin/bash

mkdir results;
javac -Xdiags:verbose ParallelRankSort.java;
for j in 1000 10000 100000;
do
	for i in 1 2 4 8 16 24 32 46 64;
	do
		echo ${j}x${i};
		java ParallelRankSort ${j} ${i} true > results/${j}x${i}.txt;
	done;
done;
