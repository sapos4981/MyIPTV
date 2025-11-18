# 📱 Como Compilar o MyIPTV - Guia Rápido

## ✅ Requisitos Mínimos

- Windows 10/11 ou macOS ou Linux
- 8GB RAM (recomendado 16GB)
- 10GB de espaço livre no disco
- Conexão com internet

## 🔧 Instalação do Android Studio

1. **Baixe o Android Studio:**
   - Acesse: https://developer.android.com/studio
   - Clique em "Download Android Studio"
   - Execute o instalador

2. **Durante a instalação:**
   - Aceite os termos de licença
   - Instale os componentes padrão
   - Configure o Android SDK (será instalado automaticamente)

3. **Primeira execução:**
   - Abra o Android Studio
   - Configure as preferências (pode usar padrão)
   - Aguarde o download dos componentes SDK

## 🚀 Compilando o Projeto

### Método 1: Abrir no Android Studio (RECOMENDADO)

1. **Abra o Android Studio**

2. **Importe o projeto:**
   ```
   File → Open → Selecione a pasta MyIPTV → OK
   ```

3. **Aguarde a sincronização:**
   - O Gradle irá baixar as dependências automaticamente
   - Pode levar 5-10 minutos na primeira vez
   - Você verá uma barra de progresso no rodapé

4. **Compile o projeto:**
   ```
   Build → Make Project (Ctrl+F9)
   ```

5. **Execute no emulador ou dispositivo:**
   ```
   Run → Run 'app' (Shift+F10)
   ```

### Método 2: Linha de Comando (Avançado)

**Windows:**
```cmd
cd MyIPTV
gradlew assembleDebug
```

**Linux/Mac:**
```bash
cd MyIPTV
./gradlew assembleDebug
```

O APK estará em: `app\build\outputs\apk\debug\app-debug.apk`

## 📲 Instalando no Celular

### Via USB (ADB)

1. **No celular:**
   - Vá em Configurações → Sobre o telefone
   - Toque 7 vezes em "Número da versão"
   - Volte e entre em "Opções do desenvolvedor"
   - Ative "Depuração USB"

2. **No PC:**
   - Conecte o celular via USB
   - No Android Studio: Run → Run 'app'
   - Ou via comando:
   ```cmd
   adb install app\build\outputs\apk\debug\app-debug.apk
   ```

### Via APK Direto

1. **Copie o APK para o celular**
2. **No celular:**
   - Configurações → Segurança
   - Ative "Fontes desconhecidas"
   - Abra o APK e instale

## 🎯 Testando o App

### 1. Adicione uma Playlist de Teste

Use uma destas URLs públicas para testar:

```
https://iptv-org.github.io/iptv/countries/br.m3u
```

### 2. Ou crie um arquivo M3U local

Crie um arquivo `teste.m3u` com este conteúdo:

```m3u
#EXTM3U
#EXTINF:-1 tvg-logo="https://example.com/logo.png" group-title="Test",Canal Teste
https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8
```

## ❌ Problemas Comuns

### Erro: "SDK not found"
**Solução:**
1. File → Project Structure
2. SDK Location → Verifique o caminho
3. Ou edite `local.properties`:
   ```
   sdk.dir=C\:\\Users\\SeuUsuario\\AppData\\Local\\Android\\Sdk
   ```

### Erro: "Gradle sync failed"
**Solução:**
1. File → Invalidate Caches / Restart
2. Ou delete a pasta `.gradle` na raiz do projeto
3. Sincronize novamente

### Erro: "Unable to resolve dependency"
**Solução:**
- Verifique sua conexão com internet
- Tools → SDK Manager → SDK Tools
- Instale "Google Repository" e "Android Support Repository"

### Erro: "Minimum supported Gradle version"
**Solução:**
- No arquivo `gradle-wrapper.properties`, verifique a versão:
  ```
  distributionUrl=https\://services.gradle.org/distributions/gradle-8.0-bin.zip
  ```

## 📝 Estrutura do Projeto

```
MyIPTV/
├── app/
│   ├── src/main/
│   │   ├── java/com/myiptv/     # Código Kotlin
│   │   ├── res/                  # Recursos (layouts, strings, etc)
│   │   └── AndroidManifest.xml   # Manifesto do app
│   └── build.gradle              # Configuração do módulo
├── build.gradle                  # Configuração raiz
└── settings.gradle               # Configuração do projeto
```

## 🔍 Verificando os Logs

Se algo não funcionar:

1. **No Android Studio:**
   - View → Tool Windows → Logcat
   - Filtre por "MyIPTV" ou "Error"

2. **Via linha de comando:**
   ```cmd
   adb logcat | findstr MyIPTV
   ```

## 📚 Próximos Passos

Após compilar com sucesso:

1. ✅ Teste adicionando uma playlist
2. ✅ Reproduza um canal
3. ✅ Experimente a busca
4. ✅ Teste os favoritos
5. 🎨 Personalize as cores em `res/values/colors.xml`
6. 📝 Altere o nome em `res/values/strings.xml`

## 🆘 Precisa de Ajuda?

- **Documentação Android:** https://developer.android.com/docs
- **Stack Overflow:** https://stackoverflow.com/questions/tagged/android
- **Android Studio Guide:** https://developer.android.com/studio/intro

## 📄 Licença e Aviso

- Este é um projeto educacional
- Use apenas com playlists legais
- Você é responsável pelo conteúdo que assiste
- O app é apenas um player de vídeo

---

**Boa sorte com seu app IPTV! 🎉**
