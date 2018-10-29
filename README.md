# Interview Questions & Solutions

## How to use

```bash
sbt run <question> arg1 arg2 ...
# run solution of a question
# ex: sbt run BinarySearch "1 2 3" "2"
# (binary search for "2" in list "1 2 3")

sbt testOnly <question>Suite
# run tests of a question
# ex: sbt testOnly BinarySearchSuite
```