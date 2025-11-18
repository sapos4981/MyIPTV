# Tutorial - Como Compilar e Usar o MyIPTV

## 🚀 Passo a Passo para Compilar

### 1. Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Android Studio** (versão Flamingo ou superior)
  - Download: https://developer.android.com/studio
  
- **JDK 17** (já vem com Android Studio)

- **Android SDK** (instalado via Android Studio)
  - SDK Platform 34 (Android 14)
  - SDK Build-Tools 34.0.0

### 2. Configurando o Projeto

1. **Abra o Android Studio**

2. **Import Project:**
   - File → Open
   - Navegue até a pasta `MyIPTV`
   - Clique em OK

3. **Configure o SDK:**
   - File → Project Structure → SDK Location
   - Verifique se o caminho do Android SDK está correto
   - Normalmente: `C:\Users\SeuUsuario\AppData\Local\Android\Sdk`

4. **Sincronize o Gradle:**
   - O Android Studio deve sincronizar automaticamente
   - Se não, clique em "Sync Now" na barra amarela
   - Ou: File → Sync Project with Gradle Files

### 3. Compilando o App

#### Opção A: Executar no Emulador

1. **Criar Emulador:**
   - Tools → Device Manager
   - Create Device
   - Escolha um dispositivo (ex: Pixel 5)
   - Escolha uma imagem de sistema (ex: API 34)
   - Finish

2. **Executar:**
   - Clique no botão ▶️ (Run) ou pressione Shift+F10
   - Aguarde o emulador iniciar
   - O app será instalado automaticamente

#### Opção B: Gerar APK

1. **Build APK:**
   - Build → Build Bundle(s) / APK(s) → Build APK(s)
   - Aguarde a compilação
   - Clique em "locate" quando aparecer a notificação
   - O APK estará em: `app/build/outputs/apk/debug/app-debug.apk`

2. **Instalar no Celular:**
   - Transfira o APK para seu celular
   - Ative "Fontes Desconhecidas" nas configurações
   - Instale o APK

### 4. Usando o App

#### Adicionar uma Playlist M3U

1. **Obtenha uma URL M3U:**
   - Exemplo: `http://exemplo.com/playlist.m3u`
   - Ou arquivo local: `file:///sdcard/playlist.m3u`

2. **No App:**
   - Clique no botão "+" (canto inferior direito)
   - Digite um nome (ex: "Minha Playlist")
   - Cole a URL da playlist
   - Clique em "ADD"
   - Aguarde o download e processamento

3. **Assistir Canais:**
   - Toque na playlist adicionada
   - Navegue pela lista de canais
   - Toque em um canal para assistir

#### Recursos Disponíveis

- **⭐ Favoritos:** Toque na estrela ao lado do canal
- **🔍 Buscar:** Use a barra de busca para encontrar canais
- **🗑️ Deletar:** Toque no ícone de lixeira na playlist

## 🛠️ Solução de Problemas

### Erro de Compilação

**Problema:** "SDK not found"
- **Solução:** Configure o caminho do SDK em `local.properties`

**Problema:** "Gradle sync failed"
- **Solução:** 
  - File → Invalidate Caches / Restart
  - Delete a pasta `.gradle` e sincronize novamente

### Problemas no App

**Problema:** "Erro ao carregar playlist"
- **Solução:**
  - Verifique a URL da playlist
  - Teste a URL no navegador
  - Verifique sua conexão com internet
  - Alguns servidores podem bloquear requisições de apps

**Problema:** "Canal não reproduz"
- **Solução:**
  - Verifique se a URL do canal está ativa
  - Teste em outro player (VLC)
  - Alguns canais requerem autenticação

## 📝 Formato M3U Suportado

```m3u
#EXTM3U
#EXTINF:-1 tvg-logo="http://logo.com/logo.png" group-title="Esportes",Canal Esportivo
http://stream.com/canal1.m3u8
#EXTINF:-1 tvg-logo="http://logo.com/logo2.png" group-title="Notícias",Canal de Notícias
http://stream.com/canal2.m3u8
```

## 🔧 Personalizações

### Mudar Cores do App

Edite: `app/src/main/res/values/colors.xml`

```xml
<color name="purple_500">#FF6200EE</color>  <!-- Cor primária -->
<color name="teal_200">#FF03DAC5</color>     <!-- Cor secundária -->
```

### Mudar Nome do App

Edite: `app/src/main/res/values/strings.xml`

```xml
<string name="app_name">Meu Player IPTV</string>
```

### Mudar Ícone

Substitua os arquivos em: `app/src/main/res/mipmap-*/`

## 📱 Testando em Dispositivo Real

1. **Ativar Modo Desenvolvedor:**
   - Configurações → Sobre o telefone
   - Toque 7 vezes em "Número da versão"

2. **Ativar Depuração USB:**
   - Configurações → Opções do desenvolvedor
   - Ative "Depuração USB"

3. **Conectar ao PC:**
   - Conecte o celular via USB
   - Aceite a depuração no celular
   - Execute o app pelo Android Studio

## 🎓 Recursos Adicionais

- **Documentação Android:** https://developer.android.com/docs
- **ExoPlayer:** https://exoplayer.dev/
- **Kotlin:** https://kotlinlang.org/docs/home.html
- **Material Design:** https://material.io/

## ⚠️ Avisos Legais

- Este app é apenas um player
- Você é responsável pelo conteúdo que assiste
- Certifique-se de ter direitos sobre o conteúdo IPTV
- Use apenas playlists legais

## 💬 Suporte

Para problemas ou dúvidas:
- Verifique os logs no Logcat do Android Studio
- Consulte a documentação oficial do Android
- Pesquise no Stack Overflow

---

**Desenvolvido com ❤️ usando Kotlin e Android**
