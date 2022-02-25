package com.example.ui_test_espresso

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivityTest::class, SecondActivityTest::class)
class ActivityTestAll

// Running All Tests At Once