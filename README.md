# Data-Structures-Simplified
This repository consists my explainations to the common data structures. This is my effort to contribute to the open source education of computer science. The repository will be constantly updated with new files. 

#!/bin/bash

#File: tree-md

tree=$(tree -tf --noreport -I '*~' --charset ascii $1 |
       sed -e 's/| \+/  /g' -e 's/[|`]-\+/ */g' -e 's:\(* \)\(\(.*/\)\([^/]\+\)\):\1[\4](\2):g')

printf "# Project tree\n\n${tree}"
