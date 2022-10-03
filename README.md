# Algeo01-21001
- --
## Tubes Algeo 1
Tubes 1 of Aljabar Linier dan Geometri (IF2123). A library linear algebra using Java. This library contains source files to solve determinant, inverse, linear system equation such as interpolation and linear regression using various methods (Gauss, Gauss-Jordan, Inverse, and Cramer). 
## Contributors (Mawar Hitam)
- 13521001 Angger Ilham Amanullah <br/>
- 13521019 Ditra Rizqa Amadia <br/>
- 13521024 Radit Naufal Abiyu <br/>
## Program Features
- Linear system equation calculator using:
  - Gauss Elimination
  - Gauss-Jordan Elimination
  - Inverse Method
  - Cramer's Rule
- Matrix determinant calculator using:
  - Cofactor
  - Elementary Row Operation
- Matrix inverse calculator using:
  - Adjoin
  - Elementary Row Operation
- Polynomial Interpolation
- Bicubic Interpolation
- Multiple Linear Regression
## Project Structure
```bash
.
├── .idea ---------------------------------------- IntelliJ's project specific settings files
├── bin ------------------------------------------ Folder containing binary files (*.class)
├── doc ------------------------------------------ Folder containing project report
│   └── Algeo01-21001.pdf
├── src ------------------------------------------ Folder containing source files (*.java)
│   └── algeo01 ---------------------------------- Project package
│       ├── application -------------------------- Application package
│       │   ├── BicubicInterpolation ------------- Bicubic Interpolation App package
│       │   │   └── Main.java
│       │   ├── Determinant ---------------------- Determinant App package
│       │   │   ├── determinantCofactor
│       │   │   │   └── Main.java
│       │   │   ├── determinantOBE
│       │   │   │   └── Main.java
│       │   │   └── Main.java
│       │   ├── InterpolasiPolinom --------------- Polynomial Interpolation App package
│       │   │   └── Main.java
│       │   ├── inverse -------------------------- Inverse App package
│       │   │   ├── inverseAdj
│       │   │   │   └── Main.java
│       │   │   ├── inverseOBE
│       │   │   │   └── Main.java
│       │   │   └── Main.java
│       │   ├── linearRegression ----------------- Linear Regression App package
│       │   │   └── Main.java
│       │   ├── SPL ------------------------------ Linear System Equation App package
│       │   │   ├── Cramer
│       │   │   │   └── Main.java
│       │   │   ├── Gauss
│       │   │   │   └── Main.java
│       │   │   ├── GaussJordan
│       │   │   │   └── Main.java
│       │   │   ├── MatriksBalikan
│       │   │   │   └── Main.java
│       │   │   └── Main.java
│       │   └── Main.java
│       ├── data --------------------------------- Class package
│       │   └── Matrix.java
│       └── function ----------------------------- Function package
│           ├── AddRowByRow.java
│           ├── BicubicInterpolator.java
│           ├── CubicInterpolator.java
│           ├── Determinant.java
│           ├── DeterminantOBE.java
│           ├── GaussElimination.java
│           ├── GaussJordanElimination.java
│           ├── Inverse.java
│           ├── InverseOBE.java
│           ├── MultiplyRowByConst.java
│           ├── NormalEstimation.java
│           ├── RowEchelonResult.java
│           ├── SubtractRowByRow.java
│           └── SwapRows.java 
├── test ------------------------------------------ Folder containing test files
│   └── spl1.txt 
└── README.md
```
## Local Setup
1. Clone this repository
2. Go to src folder: ```/src/```
2. Compile by running: ```javac -d ../bin/production/Algeo01-21001 algeo01/*.java```
3. Go to bin folder: ```/bin/production/Algeo01-21001/```
4. Run Main by running: ```java algeo01.application.Main```
## Technology Used
- Java

