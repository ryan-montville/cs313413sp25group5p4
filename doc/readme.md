Add write up here, remove everything below, not sure if packages.mgp needs to be updated


* Include a brief (300-500 words) report containing this information:
 * (0.5) Your Group development journey during this project. Focus on aspects you find noteworthy, e.g., process, pairing, testing, design decisions, refactoring, use of the repository.

The extended state machine model we created before we started working on the code had four states: Stopped, Click Active, 3 Second Countdown, and Running. Once we started working on the code we realized that we needed a Beeping state and did not need a state for the click events. Besides that change, our app followed the model we created pretty closely. One small change we made was calling the countdown state CountdownDelay instead of 3SecondCountdown, for clarity and so that it didn’t start with a number. We think that it was helpful to create the model first before coding because it helped us fully understand how the app functions.


<img src="https://raw.githubusercontent.com/ryan-montville/cs313413sp25group5p4/refs/heads/main/doc/StateDiagram.png" title="State Diagram" alt="State Diagram" style="width: 90%/" />