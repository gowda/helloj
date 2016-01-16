# helloj
A simple project to demonstrate the implementation of “hello, world” program in Java

## Build
```bash
$ ./gradlew build
```

## Run
```bash
$ ./gradlew -q :run 2>/dev/null
```

## Test
```bash
$ ./gradlew :hello:cleanTest :hello:test
```

`cleanTest` task for `gradlew` is required, otherwise `gradle` will not run the
tests until any change is applied for the test file.
