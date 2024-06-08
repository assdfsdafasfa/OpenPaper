# Testing Refactoring Engines with ChatGPT: An Empirical Study
The study's initial exploration was centered on the feasibility of utilizing ChatGPT to directly generate test cases for evaluating the performance of refactoring tools. Still, the result demonstrated less than
satisfactory outcomes. We further investigate how we can improve the ChatGPT-based testing by domain analysis and program engineering. Specifically, domain analysis fully leverages ChatGPT’s analytical abilities to examine every scenario that could potentially
trigger bugs to guide the generation of test cases. Program engineering thoroughly analyzes all possible influencing features by exploring historical bugs, and expands upon this foundation to
build the generator of ChatGPT’s prompt input. Finally, we utilize differential testing techniques based on generated test cases to identify bugs in widely used refactoring engines. The result shows
that our study discovered 113 bugs and 28 inconsistent refactoring behaviors in four refactoring engines, with 53 bugs confirmed by maintainers. 

We provide a [Bug Repository](https://assdfsdafasfa.github.io/) that contains all details (test case code before and after refactoring, error reasons, expected results). 

Auto-perform refactoring tools in [RefEclipse](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Eclipse_AutoRefactor) and [RefIDEA](https://github.com/assdfsdafasfa/OpenPaper/tree/main/IDEA_AutoRefactor) package.
Analysis of historical bug in [AnalysisOfHistoricalBug](https://github.com/assdfsdafasfa/OpenPaper/tree/main/AnalysisOfHistoricalBug) package.
# Prompt Design
**One-Step Prompt Engineering:** Evaluating the potential of directly leveraging ChatGPT to generate test cases for testing refactoring tools.

**Chain-of-Thought Prompting:** First, utilize ChatGPT's scenario analysis capabilities to analyze all scenarios that may lead to mutation errors or inconsistent behaviors in refactoring, and use ChatGPT to generate test cases based on each scenario.

**Knowledge-Based Prompting:** By analyzing the bugs of historical refactoring tools, we have obtained all the characteristics affecting the refactoring tools and expanded on this to construct a feature list. The prompts for ChatGPT are composed by randomly selecting combinations of features.

 We design the prompt engineering in the  [Prompt](https://github.com/assdfsdafasfa/OpenPaper/tree/main/Prompt) package. 
# Results
To evaluate the potential of ChatGPT on the task of testing refactoring tools, we set 6 research questions：

RQ1: Can ChatGPT help developers generate test cases that trigger bugs in refactoring engines?<br>
RQ2: How many bugs generated by ChatGPT are consistent?<br>
RQ3: Can ChatGPT help developers discover inconsistent behavior of refactoring engines? <br>
RQ4: What insights can be found from inconsistent behaviors of refactoring engines?<br>
RQ5: Is there a consensus between academia and industry regarding the testing of refactoring engines?<br>
RQ6: Which category of refactoring engine bugs do the test cases generated by ChatGPT expose?

To answer RQ1, we explore three prompting strategies leveraging ChatGPT to generate test cases that trigger bugs in refactoring engines.
![image](https://github.com/assdfsdafasfa/OpenPaper/assets/170524487/1e0dd0be-cddd-4821-b6e9-8149ee8f4a0e)

To answer RQ2, we examine the phenomenon of bug duplication in refactoring engines with respect to different types of refactoring.

To answer RQ3, we explore three prompts to investigate the efficacy of ChatGPT in producing test cases that assess the refactoring engine’s inconsistent behaviors.

To answer RQ4, RQ5, and RQ6, We provide test cases for all bugs and inconsistent behaviors found, For details, please see [Bug Repository](https://assdfsdafasfa.github.io/)
