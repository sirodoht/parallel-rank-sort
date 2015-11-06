# Parallel Rank Sort

`SeqRankSort.java` is a C-like implementation of rank sort. Demonstrated with a sample reversed array of 10 integers.

`ParallelRankSort.java` uses command line arguments for problem size and number of threads to use.

## Use

### Compile

```
javac -Xdiags:verbose SeqRankSort.java
javac -Xdiags:verbose ParallelRankSort.java
```

### Run

```
java SeqRankSort
java ParallelRankSort 1000 4
```

### Experiment

```
./run_parallel.sh
```

`run_parallel` creates a `results` directory and runs the parallel version for sample problem sizes and number of threads. It can be used as boilerplate for your own numbers for the arguments.


## License

Code releases under the [MIT license](LICENSE).
