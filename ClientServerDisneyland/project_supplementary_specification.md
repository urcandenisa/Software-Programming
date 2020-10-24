# Disneyland Supplementary Specification

# Introduction
The purpose of this document is to define requirements of the Disneyland system.
The Supplementary Specification captures the system requirements that are not readily captured in the use cases of the use-case model. Such requirements include:
Legal and regulatory requirements, including application standards.
Quality attributes of the system to be built, including usability, reliability, performance, and supportability requirements.
Other requirements such as operating systems and environments, compatibility requirements, and design constraints.

# Non-functional Requirements

## Availability
-    Attribute definition: technically, it is defined as a metric that measures the probability that a system is not failed or undergoing a repair action when it needs to be used; summing up, this means the ability of a service to answer to requests and be accessible; typically it is measured as a factor of its reliability.
-    Source of stimulus: the entity (human or another system) that generated the stimulus or event
-    Stimulus: a condition that determines the reaction of the system:
                                a component fails to respond,
                                a component responds but the response is late.
 -    Environment: the current condition of the system when the stimulus arrives; it may be in normal state or in a degraded state.
-    Artifact: is a component that reacts to the stimulus. It may be the whole system or some pieces of it.
-    Response: the activity determined by the arrival of the stimulus.
-    Response measure: the quantifiable indication of the response, also known as a notification.
## Performance
-    Attribute definition: in context of services it is defined as the time required by the system to respond to a certain event( latency)
-    Source of stimulus: external, the user(human), performing an action on the system.
-    Stimulus: an external event provided by accessing a system service, such as logging in, register etc.
-    Environment: the system may be in a normal, functional state.
-    Artifact: the system's service.
-    Response: a change in the system's environment representing the result of the action made on the system; it can reach a degraded state, which may cause loss of data
-    Response measure: time needed for the system to process arriving events( including the events that can not be processed)
## Security
-    Attribute definition: it has 2 major aspects, such as confidentiality and authenticity; it is defined as a measure of the system's ability to resist unauthorized usage and to trust the provided infromation 
-    Source of stimulus: an unauthorized person
-    Stimulus: tries to break the system, accessing data( data privacy) or system services
-    Environment: the system may be in a normal state.
-    Artifact: the system's service.
-    Response: blocks the access to system(data or services).
-    Response measure: time needed for the system to detect the attack
## Testability
-    Attribute definition: it matters when it comes to building and automating tests of individual components or interactions between components, to ensure developers can move fast and detect defects early; this refers to the degree of a software artifact support testing.
-    Source of stimulus: user( tester, developer)
-    Stimulus: test classes
-    Environment: development, deployment, runtime.
-    Artifact: the whole system or certain components.
-    Response: can be observed, controlled, modified; it is a clear run or exited with an error.
-    Response measure: 
## Usability
-    Attribute definition: is the degree to which a software can be used by specified consumers to achieve quantified objectives with effectiveness, efficiency, and satisfaction in a quantified context of use; it measures the quality of user experience a service provides
-    Source of stimulus: user
-    Stimulus: aims to improve user experience
-    Environment: runtime
-    Artifact: the whole system.
-    Response: provide usability
-    Response measure: user's satisfaction
# Design Constraints
* The data used in the application will be stored in a database. The server that will store the required information can be installed on a remote computer, but requires an SQL server. 
* The application will be designed in Intellij. It is necessary to have a JVM installed on the computer on which the application runs. 
* The application is designed using Model-View-Controller. It is mandatory that the Controller/Model classes don't have direct reference to the View Class, but through an interface if needed.

# Resources

* http://www.upedu.org/process/gdlines/md_srs.htm
* Example of Supplementary Specification: http://csis.pace.edu/~marchese/SE616_New/Samples/Example%20%20Supplementary%20Specification.htm
