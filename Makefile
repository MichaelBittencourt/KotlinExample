COMPILER=kotlinc
RUNNER=kotlin

COMPILE_FLAGS=-include-runtime

#RUNNER_FLAGS=-classpath hello.jar HelloKt


BIN=hello.jar


$(BIN): hello.kt
	$(COMPILER) $< $(COMPILE_FLAGS) -d $@

.PHONY: clean run

clean:
	rm $(BIN) *.class

run: $(BIN)
	$(RUNNER) $<
