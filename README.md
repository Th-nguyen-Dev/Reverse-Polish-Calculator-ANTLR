# Reverse Polish Calculator ANTLR

A calculator application that converts standard mathematical expressions to Reverse Polish Notation (RPN) and evaluates them using ANTLR (ANother Tool for Language Recognition).

## Overview

This project implements a calculator that processes mathematical expressions, converts them to Reverse Polish Notation (also known as postfix notation), and evaluates them. It uses ANTLR4 for parsing expressions and the Visitor pattern for traversing and evaluating the parse tree.

## Features

- Parses standard mathematical expressions
- Converts expressions to Reverse Polish Notation
- Supports basic arithmetic operations:
  - Addition
  - Subtraction
  - Multiplication
  - Division
- Handles negative numbers and complex expressions

## Getting Started

### Prerequisites

- Java 8 or higher
- Gradle (or use the included wrapper)

### Building the Project

```bash
./gradlew build
```

This will:
1. Generate the ANTLR parser and lexer classes
2. Compile the Java code
3. Run the tests

### Running the Application

```bash
./gradlew run
```

## Implementation Details

The calculator uses ANTLR4 to define a grammar for mathematical expressions. The process flow is:

1. Input expression is parsed by ANTLR-generated lexer and parser
2. The resulting parse tree is traversed by a post-order visitor (`ExprPostOrderVisitor`)
3. The visitor converts the expression to Reverse Polish Notation using `Atom` objects
4. The expression can then be evaluated following RPN rules

### Project Structure

- `src/main/antlr`: Contains ANTLR grammar files
- `src/main`: Java implementation files
  - `antlr`: Generated ANTLR code
  - `logic`: Core logic including `Atom` class for expression handling
- `src/test`: JUnit tests for verifying functionality

## Testing

The project uses JUnit Jupiter (JUnit 5) for testing. Various test cases verify correct handling of different mathematical operations and edge cases.

To run the tests:

```bash
./gradlew test
```

## License

[Include license information here]

## Acknowledgments

- ANTLR project (https://www.antlr.org/)
- JUnit Testing Framework
