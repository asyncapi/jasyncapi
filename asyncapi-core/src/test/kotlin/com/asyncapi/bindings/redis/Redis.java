package com.asyncapi.bindings.redis;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Redis")
@SelectPackages("com.asyncapi.bindings.redis")
public class Redis {}