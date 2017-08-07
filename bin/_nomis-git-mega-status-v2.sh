# Run this by passing it to bash as a command line arg.
# This shebang doesn't work on Android: #!/bin/bash

_nomis-git-mega-status-v1.sh | grep -v "^## master...origin/master$"
