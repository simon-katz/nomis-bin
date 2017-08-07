#!/bin/bash

_nomis-git-mega-status-v1.sh | grep -v "^## master...origin/master$"
