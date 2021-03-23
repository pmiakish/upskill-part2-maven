UpSkill-part2-maven
-------------------
> This is a training project by P. Miakish

***

#### SuffixingApp

It is a java application that refers to a config file and renames a set of files adding a suffix specified in the same config.

#### Details:

- The application reads a JSON or XML config file on the startup
- Then it renames each file adding a suffix from the config to its name, if all the specified files are exist
- It throws FileNotFoundException in the case when the file or files do not exist
- It prints the results of the renaming in console in the following way: _"old_name -> new_name"_

The application uses the Log4j 2 dependency for logging. It writes to both text and JSON log files  following information:
- application startup information
- configuration reading information 
- file checking information
- renaming process information
- some summary information (e.g. a number of existing files)
- application shutdown information
- exceptions throwing information 
- execution time

#### Launching

_start/FileController.java_

***

#### Testing Quadratic Equation

It is a java application that that solves a quadratic equation.

#### Details:

- Application reads a set of coefficients from the specified file on the startup
- Then it solves a quadratic equation in accordance with given parameters (finds one or two roots, or reports that the equation has no roots)
- It throws IllegalArgumentException in the case the value of 'a'-coefficient is zero
- RootCalculatorTest.java has a set of JUnit methods which ensure that:
	- method works fine in general cases: two existing roots, one exiting root or no roots
	- method works correctly if some coefficients equal zero
	- method works correctly in special cases (like when 'a'-coefficient or all coefficients equal zero)

#### Launching

_start/QuadraticEquationController.java_