/*
 * (C) Copyright 2018 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.seljup.test.docker;

import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import static io.github.bonigarcia.seljup.BrowserType.FIREFOX;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@Disabled("Redudant test in CI")
@ExtendWith(SeleniumJupiter.class)
class DockerBetaAndDevJupiterTest {

    @Test
    void testChromeBeta(
            @DockerBrowser(type = CHROME, version = "beta") WebDriver driver) {
        exercise(driver);
    }

    @Test
    void testChromeDev(
            @DockerBrowser(type = CHROME, version = "dev") WebDriver driver) {
        exercise(driver);
    }

    @Test
    void testFirefoxBeta(
            @DockerBrowser(type = FIREFOX, version = "beta") WebDriver driver) {
        exercise(driver);
    }

    @Test
    void testFirefoxDev(
            @DockerBrowser(type = FIREFOX, version = "dev") WebDriver driver) {
        exercise(driver);
    }

    private void exercise(WebDriver driver) {
        driver.get("https://bonigarcia.org/selenium-jupiter/");
        assertThat(driver.getTitle())
                .contains("JUnit 5 extension for Selenium");

        // Thread.sleep(50000);
    }

}
