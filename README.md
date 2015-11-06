# Parallel Rank Sort

`SeqRankSort.java` is a C-like implementation of rank sort. Demonstrated with a sample reversed array of 10 integers.

`ParallelRankSort.java` uses command line arguments for problem size and number of threads to use. It divides the array to be sorted into equal[1] blocks, which are then divided to each thread. The work of each thread is to calculate the position of each element in the (`result`) array.

*[1] In case of remainder `Math.ceil` is invoked.*

## Use

### Compile

```sh
javac -Xdiags:verbose SeqRankSort.java
javac -Xdiags:verbose ParallelRankSort.java
```

### Run

```sh
java SeqRankSort
java ParallelRankSort 1000 4 true
```

`ParallelRankSort` arguments:

1. `1000` problem size, that is the number of elements of the array.
1. `4` problem size, that is the number of elements of the array.
1. `true` random boolean, true means random array elements while every other statement evaluates false.

Also available by running `java ParallelRankSort` argument-less.

### Experiment

```sh
./run_parallel.sh
```

`run_parallel` creates a `results` directory and runs the parallel version for sample problem sizes and number of threads. It can be used as boilerplate for your own numbers for the arguments.


## License

Code released under the [MIT license](LICENSE).
