<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![License: GPL v3][license-shield]][license-url]
[![Javadoc][javadoc-shield]][javadoc-url]
[![MavenCentral][maven-shield]][maven-url]




<!-- PROJECT LOGO -->
<br />
<div align="center">
  <!-- a href="https://github.com/mlgr-io/kotlin-api-core">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a //-->

<h3 align="center">kotlin-api-core</h3>

  <p align="center">
    Kotlin model library for usage with various mailguru.io APIs. 
    <!-- br />
    <a href="https://github.com/mlgr-io/kotlin-api-core"><strong>Explore the docs »</strong></a //-->
    <br />
    <br />
    <!-- a href="https://github.com/mlgr-io/kotlin-api-core">View Demo</a>
    · //-->
    <a href="https://github.com/mlgr-io/kotlin-api-core/issues">Report Bug</a>
    ·
    <a href="https://github.com/mlgr-io/kotlin-api-core/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Kotlin model library for usage with various mailguru.io APIs.

The error and exception model classes are object representations of
[JSON:API Error objects](https://jsonapi.org/format/#error-objects) (though the mapping itself happens at higher level
libraries).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Since this is a low-level mode library that is used within our [API client library](https://github.com/mlgr-io), there
isn't much to see here. We don't provide explicit usage documentation for this library; but you may look into the
[Javadoc](https://javadoc.io/doc/io.mailguru/api-core) in case you are wondering.

### Prerequisites

We choose to support the lowest actively supported Java version at the time of writing, that is, Java 11 (this may be
subject to change in future major releases). There are no additional dependencies other than Kotlin and some plugins
for publishing and documentation (Dokka).

### Installation

There are several ways to install this library:

1. Apache Maven
   ```
   <dependency>
     <groupId>io.mailguru</groupId>
     <artifactId>api-core</artifactId>
     <version>0.1.0</version>
   </dependency>
   ```
2. Gradle Groovy DSL
   ```
   implementation 'io.mailguru:api-core:0.1.0'
   ```
3. Gradle Kotlin DSL
   ```
   implementation("io.mailguru:api-core:0.1.0")
   ```
4. Or you may clone the latest `develop` branch of this repository and publish it to your local maven repository: 
   ```sh
   git clone https://github.com/mlgr-io/kotlin-api-core.git
   cd kotlin-api-core
   ./gradlew publishToMavenLocal
   ```
   Then, in your target project, import the local lib by one of the methods above. Please make sure that the `version`
   you import matches the value given in your local
   [build.gradle](https://github.com/mlgr-io/kotlin-api-core/blob/develop/build.gradle) and you local maven repository:
   ```sh
   repositories {
	 mavenLocal()
	 // ...
   }
   ```
 

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the **GNU General Public License v3.0**. See [LICENSE.md](LICENSE.md) for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Project Link: [https://github.com/mlgr-io/kotlin-api-core](https://github.com/mlgr-io/kotlin-api-core)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [https://github.com/othneildrew/Best-README-Template](https://github.com/othneildrew/Best-README-Template)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[javadoc-url]: https://javadoc.io/doc/io.mailguru/api-core
[javadoc-shield]: https://javadoc.io/badge2/io.mailguru/api-core/javadoc.svg?style=for-the-badge&color=yellow
[maven-url]: https://search.maven.org/artifact/io.mailguru/api-core
[maven-shield]: https://img.shields.io/maven-central/v/io.mailguru/api-core?style=for-the-badge
[contributors-shield]: https://img.shields.io/github/contributors/mlgr-io/kotlin-api-core.svg?style=for-the-badge
[contributors-url]: https://github.com/mlgr-io/kotlin-api-core/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mlgr-io/kotlin-api-core.svg?style=for-the-badge
[forks-url]: https://github.com/mlgr-io/kotlin-api-core/network/members
[stars-shield]: https://img.shields.io/github/stars/mlgr-io/kotlin-api-core.svg?style=for-the-badge
[stars-url]: https://github.com/mlgr-io/kotlin-api-core/stargazers
[issues-shield]: https://img.shields.io/github/issues/mlgr-io/kotlin-api-core.svg?style=for-the-badge
[issues-url]: https://github.com/mlgr-io/kotlin-api-core/issues
[license-shield]: https://img.shields.io/github/license/mlgr-io/kotlin-api-core.svg?style=for-the-badge
[license-url]: https://github.com/mlgr-io/kotlin-api-core/blob/master/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com
