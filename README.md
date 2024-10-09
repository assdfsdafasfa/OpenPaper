# ChatGPT-based Test Generation for Refactoring Engines Enhanced by  Feature Analysis on Examples
# Count the number of different bug error reasons
====>Table 1 Classification of defects  based on paper【[An Empirical Study of Refactoring Engine Bugs](https://arxiv.org/abs/2409.14610)】

![image](https://github.com/user-attachments/assets/e96681e8-05ba-4b19-ad8c-4073378a4401)
# Bug list
All bugs identified in the case study are explained in detail so that they could be validated by other researchers. The bug list is publicly available [here](https://assdfsdafasfa.github.io/). 

For each bug, we present the code before and after refactoring, the expected results, explanations, and error messages generated by compilers(if there is any)

![image](https://github.com/user-attachments/assets/322b5448-e22f-4cb6-a418-8d946ce07daa)

  **[Feature Library](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Dataset/FeatureLibrary):** Features derived from the collected bug reports and test cases. 
    ![image](https://github.com/user-attachments/assets/0a19017b-c59d-4561-a602-c0dc124c8108)

  **[Analyzed Test Cases](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Dataset/AnalyzedTestCases):** Test cases collected and analyzed in the case study. 
![image](https://github.com/user-attachments/assets/1f767d68-8dca-43be-8883-5259f490e254)

  **[Analyzed Bug Reports](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Dataset/AnalyzedBugReports):** Public bug reported collected and analyzed the case study. 
  ![image](https://github.com/user-attachments/assets/13b36d20-b0b0-4c6f-b1ac-eb1ff9fa9754)

# How to reproduce the case study

**1.Requirements**

. JDK == 17

• Eclipse, version 2024.3 

• NetBeans, version 21 

• VScode-java, version 1.22.0 

• IntelliJ IDEA, version 2024.1

**2.Step-by-step tutorial**

Download the implementation at: git clone git@github.com:assdfsdafasfa/OpenPaper.git

1. A tool that performs automated execution of refactoring by calling refactoring engines([Auto-RefactoringbyEclipse](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Implementation/Eclipse_AutoRefactor) and [Auto-RefactoringbyIDEA](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Implementation/IDEA_AutoRefactor)) API.

(1) Import Project

import->Existing Projects into Workspace->Auto-RefactoringbyEclipse->plugin.xml->Launch an Eclipse application
   
   ![image](https://github.com/user-attachments/assets/73d293ee-0a62-4a4e-a200-7b9999a4fed1)

open-> Auto-RefactoringbyIDEA->EveryRefactoring
   
   ![image](https://github.com/user-attachments/assets/af61bf0e-1a31-4d86-b070-1c0b1df201cb)

(2) Sequential run refactoring in Eclipse and IntelliJ IDEA, and Save code after refactoring.

(3) Compare Refactoring Codes.
   
   ![image](https://github.com/user-attachments/assets/724fff2a-2498-4bc1-b7e2-b76424256be7)

2. We provide [prompts](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Implementation/Prompt/Generator) designed for 7 types of refactoring.

   ![image](https://github.com/user-attachments/assets/e45d9656-ef86-4610-980c-8087d757528d)

# BaseLine
**Paper: Systematic Testing of Refactoring Engines on Real Software Projects**  **[BaeLine URL](http://mir.cs.illinois.edu/rtr)** 

