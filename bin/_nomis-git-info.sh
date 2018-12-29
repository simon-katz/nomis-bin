# Run this by passing it to bash as a command line arg.
# This shebang doesn't work on Android: #!/bin/bash

git status -s -b
git branch -vv | grep ahead\\\|behind
