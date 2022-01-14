log for logging
==

this is a *WORKS FOR ME* project [tm]. i created it to solve an issue i had
with a single project. to use it for other projects some additions may be
necessary.

target
--

this is a project that aims to replace log4j entirely with a log feature as you
would expect. no data / code mix, no feature nobody uses. nothing special, only
logging.

some assembly required
--

it means you fix (add) all the stuff, mainly with noop stubs that your fine
software requires. remove `log4j*` and add this library. fix exception like
`Exception in thread "main" java.lang.NoSuchMethodError:
'org.apache.logging.log4j.Logger
org.apache.logging.log4j.LogManager.getLogger()'` until your project works.

missing
--

things that i want to add but did not do so yet:

- log4j has a complex config infrastructure. i want to replace that with a
  single configfile with a fix name (if you cannot make it, change the code, it's
  included) with mainly two settings: logfile and loglevel
- loggs have to be written to files and files must be rotated, that is a feature
  logging must support, rotation and naming decision should be in code
- MDCs are a nice thing to transport information through foreign libraries that
  log but are missing context information
- a filtering by logger is sometimes usefull for debugging busy servers
- support for threading

anti features
--

features that will not make it into this project:

- colors
- complex config
- dependencies
- hotdeploy
- timezones
- xml

so no PRs about those please. feel free to add it for your own benefit.

