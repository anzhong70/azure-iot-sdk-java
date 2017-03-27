#!/bin/bash
# Copyright (c) Microsoft. All rights reserved.
# Licensed under the MIT license. See LICENSE file in the project root for full license information.

build_root=$(cd "$(dirname "$0")/.." && pwd)

# -- Java Dependencies --
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
cd $build_root/deps
mvn install
[ $? -eq 0 ] || exit $?

# -- Java Service Client --
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
cd $build_root/service
mvn install
[ $? -eq 0 ] || exit $?

# -- Java Service Client - integration tests --
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
cd $build_root/iot-service-tests
mvn install -DskipITs=false
[ $? -eq 0 ] || exit $?

# -- Java Device Client --
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
cd $build_root/device
mvn install
[ $? -eq 0 ] || exit $?

# -- Java Device Client -integration tests --
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
cd $build_root/iot-device-tests
mvn install -DskipITs=false
[ $? -eq 0 ] || exit $?

