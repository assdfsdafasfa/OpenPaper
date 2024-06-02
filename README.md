# Testing Refactoring Engines with ChatGPT: An Empirical Study
The study's initial exploration was centered on the feasibility of utilizing ChatGPT to directly generate test cases for evaluating the performance of refactoring tools. Still, the result demonstrated less than
satisfactory outcomes. We further investigate how we can improve the ChatGPT-based testing by domain analysis and program engineering. Specifically, domain analysis fully leverages ChatGPT’s analytical abilities to examine every scenario that could potentially
trigger bugs to guide the generation of test cases. Program engineering thoroughly analyzes all possible influencing features by exploring historical bugs, and expands upon this foundation to
build the generator of ChatGPT’s prompt input. Finally, we utilize differential testing techniques based on generated test cases to identify bugs in widely used refactoring engines. The result shows
that our study discovered 113 bugs and 28 inconsistent refactoring behaviors in four refactoring engines, with 53 bugs confirmed by maintainers. 

We provide a [Bug Repository](https://github.com/assdfsdafasfa/OpenPaper/blob/main/Web/main.html) that contains all details (test case code before and after refactoring, error reasons, expected results).
# Prompt Design
**One-Step Prompt Engineering:** Evaluating the potential of directly leveraging ChatGPT to generate test cases for testing refactoring tools.

**Chain-of-Thought Prompting:** First, utilize ChatGPT's scenario analysis capabilities to analyze all scenarios that may lead to mutation errors or inconsistent behaviors in refactoring, and use ChatGPT to generate test cases based on each scenario.

**Knowledge-Based Prompting:** By analyzing the bugs of historical refactoring tools, we have obtained all the characteristics affecting the refactoring tools and expanded on this to construct a feature list. The prompts for ChatGPT are composed by randomly selecting combinations of features.
# Results
To evaluate the potential of ChatGPT on the task of testing refactoring tools, we set 6 research questions：

RQ1: How does the potential of ChatGPT generate test cases that trigger bugs in refactoring engines?<br>
RQ2: Are refactoring engines more susceptible to the influence of identical test cases?<br>
RQ3: How does the potential of ChatGPT generate test cases that trigger inconsistent behavior of refactoring engines?<br>
RQ4: What refactoring engine bugs do the test cases generated by ChatGPT find?<br>
RQ5: What are the findings of inconsistent refactoring behaviors of refactoring engines discovered from test cases?<br>
RQ6: Is there a consensus between academia and industry regarding the testing of refactoring engines?

To answer RQ1, we explore three prompting strategies leveraging ChatGPT to generate test cases that trigger bugs in refactoring engines.
![image](https://github.com/assdfsdafasfa/OpenPaper/assets/170524487/acea5eb0-bed5-4420-ba1a-49237e0000a7)

To answer RQ2, we examine the phenomenon of bug duplication in refactoring engines with respect to different types of refactoring.

To answer RQ3, we explore three prompts to investigate the efficacy of ChatGPT in producing test cases that assess the refactoring engine’s inconsistent behaviors.

To answer RQ4, RQ5 and RQ6, We provide test cases for all bugs and inconsistent behaviors found, For details, please see [Bug Repository](https://github.com/assdfsdafasfa/OpenPaper/blob/main/Web/main.html)
