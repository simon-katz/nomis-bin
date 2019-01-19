# Run this by passing it to bash as a command line arg.
# This shebang doesn't work on Android: #!/bin/bash

# Do things to all git directories below current directory.
# Skips directories that contain a file called .ignore

# Copied from
# http://stackoverflow.com/questions/11981716/how-to-quickly-find-all-git-repos-under-a-directory
# with modifications.

################################################################################
#### Colours

RED=`tput setaf 1`
GREEN=`tput setaf 2`
RESET=`tput sgr0`

HIGHLIGHT=${GREEN}
NORMAL=${RESET}

################################################################################

ARGS="$*"

function do_things {
  local d="$1"
  if [ -d "$d" ]; then
    if [ -e "$d/.ignore" ]; then
      echo -e "${HIGHLIGHT}__________________________________________________"
      echo -e "${HIGHLIGHT}Ignoring $d${NORMAL}"
    else
      cd $d > /dev/null
      if [ -d ".git" ]; then
        echo -e "${HIGHLIGHT}__________________________________________________"
        echo -e "${HIGHLIGHT}$PWD$NORMAL"
        $ARGS
        true
      else
        scan *
      fi
      cd .. > /dev/null
    fi
  fi
  #echo "Exiting do_things: pwd=`pwd`"
}

function scan {
  #echo "`pwd`"
  for x in $*; do
    do_things "$x"
  done
}

echo -e "${HIGHLIGHT}Scanning ${PWD}${NORMAL}"
scan .
