# Run this by passing it to bash as a command line arg.
# This shebang doesn't work on Android: #!/bin/bash

_nomis-git-mega-status-v1.sh | \
    grep -v "^## master...origin/master$" | \
    grep -v "^## tutorial-18...origin/tutorial-18$" | \
    grep -v "^## nomis...origin/nomis$" | \
    grep -v "^## nomis-0-10-0...origin/nomis-0-10-0$" | \
    grep -v "^## simon-post-dojo-stuff...origin/simon-post-dojo-stuff$" 
