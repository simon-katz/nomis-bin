# Run this by passing it to bash as a command line arg.
# This shebang doesn't work on Android: #!/bin/bash

# Short status of current branch.
git status --short --branch

# Branches which are ahead or behind.
git branch -vv | grep ahead\\\|behind

# Local branches with no remote.
git branch -vv | cut -c 3- | awk '$3 !~/\[/ { print "Only local: "$1 }'
