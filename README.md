# JurassicParkJavaProject
Java project Jurassic Park (Week 9 CodeClan course)
A Jurassic Park themed management system where the user can manage the dinosaur population and visitor tracking of the park.

Java project:
Mockito used for testing random methods

Users are able to:
- add and remove paddocks to the park
- add and remove visitors to the park (they will pay on entry and park will collect payment)
- add and remove dinosaurs to paddocks
- feed dinosaurs
- repair paddock boundaries
- have dinosaurs rampage if they are hungry (random)
- have dinosaurs escape
- Velociraptors can call for backup


Things I'd modify:
- Modify dinosaurEscapes method so is only possible if hunger level is higher than that required to just rampage
- Modify dinosaurHitBoundary method to account for possibility of escape after one hit if health brought down to 0 (ie if has not been repaired)
- think about availability of methods, make it more obvious which methods should be used in what context.
- allow all paddocks to be emptied and improve the Velociraptor callForBackup function.
- PaddockType enum is currently redundant
