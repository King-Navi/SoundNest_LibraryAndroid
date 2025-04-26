<h1>🎵 SoundNest Library Android</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Status-Stable-brightgreen" alt="status" />
  <img src="https://img.shields.io/badge/License-MIT-blue" alt="license" />
</p>

<h2>📦 Instalación</h2>

<p>Para instalar la librería en tu proyecto Android:</p>

<h3>1. Agrega JitPack a tu <code>settings.gradle</code></h3>

<pre><code>pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
</code></pre>

<h3>2. Agrega la dependencia en tu <code>build.gradle</code> del módulo <code>app</code></h3>

<pre><code>dependencies {
    implementation("com.github.King-Navi:SoundNest_LibraryAndroid:v0.0.1-Alpha")
}
</code></pre>

<h2>⚙️ Requisitos</h2>

<ul>
    <li>Android Studio Giraffe o superior</li>
    <li>Gradle 8.x</li>
    <li>Kotlin 1.9+</li>
    <li>JDK 17+</li>
</ul>
<h2>📌 ¿Cómo actualizar la versión?</h2>

<p>Cuando haya una nueva versión de la librería (por ejemplo <code>v0.0.7-Alpha</code> o <code>v1.0.0</code>), simplemente cambia el número de versión en tu archivo <code>build.gradle</code> del módulo <code>app</code>.</p>

<h3>Ejemplo:</h3>

<p>Supongamos que se libera la versión <code>v0.0.7-Alpha</code>. Actualiza la dependencia así:</p>

<pre><code>dependencies {
    implementation("com.github.King-Navi:SoundNest_LibraryAndroid:v0.0.7-Alpha")
}
</code></pre>

<p><strong>Tip:</strong> Siempre puedes consultar la última versión disponible en <a href="https://jitpack.io/#King-Navi/SoundNest_LibraryAndroid" target="_blank">JitPack.io</a>.</p>

<h2>🛠 Cómo importar en IntelliJ IDEA</h2>

<p>Este proyecto está basado en Gradle (usa <code>build.gradle.kts</code> y <code>settings.gradle.kts</code>), por lo que IntelliJ IDEA puede importarlo automáticamente.</p>

<h3>Pasos:</h3>

<ol>
  <li>Abre <strong>IntelliJ IDEA</strong>.</li>
  <li>En la pantalla principal, haz clic en <strong>Open</strong> (Abrir).</li>
  <li>Navega a la carpeta raíz del proyecto (donde está el archivo <code>build.gradle.kts</code>).</li>
  <li>Selecciona la carpeta y presiona <strong>OK</strong>.</li>
  <li>IntelliJ detectará automáticamente que es un proyecto Gradle y preguntará si quieres importar. Acepta.</li>
  <li>Espera a que finalice la sincronización e indexación (puede tardar unos minutos la primera vez).</li>
</ol>

<p>✅ ¡Y ya podrás trabajar normalmente!</p>

<h3>Tip adicional:</h3>
<p>Si quieres que Gradle se sincronice automáticamente cada vez que hagas cambios en archivos <code>.gradle.kts</code>, puedes habilitarlo así:</p>

<ol>
  <li>Ve a <strong>File &gt; Settings &gt; Build, Execution, Deployment &gt; Build Tools &gt; Gradle</strong>.</li>
  <li>Activa la opción <strong>"Auto-import"</strong> o <strong>"Reload project on changes in build scripts"</strong>.</li>
</ol>


<h2>🏷️ Cómo crear y publicar una nueva versión (Tag)</h2>

<p>Cuando hagas cambios importantes en la librería y quieras liberar una nueva versión para que esté disponible en JitPack, debes crear un <strong>Tag</strong> en Git.</p>

<h3>Pasos para crear y subir un nuevo Tag:</h3>

<ol>
  <li>Guarda y haz commit de tus cambios:</li>
</ol>

<pre><code>git add .
git commit -m "Descripción de los cambios"
git push origin main
</code></pre>

<ol start="2">
  <li>Crea un nuevo tag siguiendo la convención <a href="https://semver.org/" target="_blank">Semantic Versioning (SemVer)</a>:</li>
</ol>

<pre><code>git tag v0.0.7-Alpha
</code></pre>

<ol start="3">
  <li>Sube el tag al repositorio remoto:</li>
</ol>

<pre><code>git push origin v0.0.7-Alpha
</code></pre>

<ol start="4">
  <li>Espera unos minutos y verifica en <a href="https://jitpack.io" target="_blank">JitPack.io</a> que la nueva versión esté publicada con <strong>Status: Success</strong>.</li>
</ol>

<p><strong>¡Listo!</strong> Tu nueva versión estará disponible para que los proyectos Android la consuman.</p>

<h3>📖 ¿Qué es Semantic Versioning (SemVer)?</h3>

<p>Usamos la convención de versiones semánticas (<a href="https://semver.org/" target="_blank">SemVer</a>) para mantener orden y claridad en los cambios del proyecto.</p>

<ul>
  <li><strong>vMAJOR.MINOR.PATCH</strong> (por ejemplo <code>v1.2.3</code>).</li>
  <li><strong>MAJOR</strong>: Se incrementa cuando haces cambios incompatibles en la API.</li>
  <li><strong>MINOR</strong>: Se incrementa cuando agregas funcionalidades compatibles.</li>
  <li><strong>PATCH</strong>: Se incrementa para correcciones de errores menores o pequeños cambios compatibles.</li>
</ul>

<p>Ejemplos:</p>

<ul>
  <li><code>v1.0.0</code>: Primera versión estable.</li>
  <li><code>v1.1.0</code>: Se agregó una nueva funcionalidad (compatible).</li>
  <li><code>v1.1.1</code>: Se corrigió un error menor.</li>
  <li><code>v2.0.0</code>: Cambio mayor que rompe compatibilidad.</li>
</ul>

<h2>🚀 Uso básico</h2>

<pre><code>import soundNest.auth.LoginClient

val loginClient = LoginClient("https://your-api-url/")

// Crear un nuevo usuario
val result = loginClient.createUser(
    username = "nombreUsuario",
    email = "correo@example.com",
    password = "contraseñaSuperSegura"
)

// Hacer login
val loginResult = loginClient.login(
    username = "nombreUsuario",
    password = "contraseñaSuperSegura"
)
</code></pre>

<h2>📚 Recursos</h2>

<ul>
    <li><a href="https://jitpack.io">Documentación de JitPack</a></li>
    <li><a href="https://github.com/King-Navi/SoundNest_LibraryAndroid">Repositorio de SoundNest Library</a></li>
</ul>
