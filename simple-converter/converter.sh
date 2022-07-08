#!/usr/bin/env bash

main() {
  echo -e "Enter a definition: \n"
  read -r -a user_input
  echo "${user_input[0]} ${user_input[1]}"
}


main
