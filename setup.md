# TestAPI

An API to use with QA interview exercise.

It a semi-realistic API that contains information about employees working at a consultancy.

- It has an _/employee_ url that allows new employees to be added via a post request.
- It also has an _/employee/id_ get endpoint so employees can see their own data using their id
- It has an _/employee_ url with query parameters to allow you to query the employee database
- It also includes admin access to view all employees via an _/employee/all_ endpoint that requires a x-admin-key header parameter to only allow admin access to this information.
- It includes a get and post endpoints at _/admin_ to get a list of admins and to set an admin key

## Setup

### Mac

1. Install [brew](https://brew.sh/) using this command in your terminal `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)`
2. Install podman using brew, run this command `brew install podman` in a new terminal
3. Install podman-compose using brew `brew install podman-compose`

### Windows

1. Download the podman windows installer (podman-4.8.2-setup.exe) from [here](https://github.com/containers/podman/releases) and run it to install podman
2. Download the python windows installer from [here](https://www.python.org/downloads/windows/) and run it to install python
3. Install podman-compose using the following command `pip3 install podman-compose` in your terminal

### Linux

___To Do___

## Using podman to setup the API service

Start your podman machine using following commands

``` bash
podman machine init
podman machine start
```

You should have received __compose.yml__ file.
Please download that on your machine and move it to the directory you wish to start the service up in.
Please note this will create files within the directory you are running in.

### Bringing the service up

To bring the service up use following command with the _compose.yml_ you were previvously given.

``` bash
podman compose -f compose.yml up
```

## Setting up the database for the interview data

Once you have the service running, go to your browser and go to this url

<http://localhost:5001/setup>

and this should set up your database with the relevant information you will use in the interview. You should see "setup complete" in your browser once the database is finished. To double check you can use the <http://localhost:5001/admin> endpoint and see if you get a list of names.

## Bringing the service down

Once you have done with your interview exercise you can bring the service back down again using the command

``` bash
podman compose -f compose.yml down
```

## Removing Podman machine

To clean up after the excise, you can stop and remove your podman machine using the following commands

``` bash
podman machine stop
podman machine rm
```

and say yes when prompted to delete the machine.

## Other useful podman commands

Here is a list of other commands that you might find useful

- To see all running containers : `podman container ls`
- To stop a container manually : `podman container stop <container-name>`
- To remove a container manually : `podman container rm <container-name>`
- To see your images : `podman image ls`
- To remove an image : `podman image rm`
