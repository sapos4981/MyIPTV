# MyIPTV

Um aplicativo IPTV moderno para Android, similar ao IBO Player Pro.

## Características

- 📺 Reprodução de canais IPTV via M3U playlists
- 🎬 Player de vídeo robusto usando ExoPlayer (suporta HLS, RTSP, HTTP)
- 💾 Gerenciamento de playlists localmente com Room Database
- ⭐ Sistema de favoritos para canais
- 🔍 Busca de canais por nome
- 📱 Interface moderna usando Material Design
- 🎨 Logos de canais e grupos
- 🔄 Suporte para múltiplas playlists

## Requisitos

- Android Studio Arctic Fox ou superior
- Android SDK 21+ (Android 5.0 Lollipop)
- Gradle 8.0+
- Kotlin 1.9.0+

## Como Compilar

1. Clone o repositório:
```bash
git clone <seu-repositorio>
cd MyIPTV
```

2. Abra o projeto no Android Studio

3. Sincronize o Gradle:
   - File > Sync Project with Gradle Files

4. Execute o app:
   - Run > Run 'app'
   - Ou pressione Shift+F10

## Como Usar

1. **Adicionar Playlist:**
   - Clique no botão "+" (FAB)
   - Digite o nome da playlist
   - Cole a URL do arquivo M3U
   - Clique em "Add"

2. **Assistir Canais:**
   - Selecione uma playlist
   - Navegue pela lista de canais
   - Clique em um canal para assistir

3. **Favoritos:**
   - Clique na estrela ao lado do canal
   - Acesse seus favoritos facilmente

4. **Buscar Canais:**
   - Use a barra de busca no topo
   - Digite o nome do canal

## Tecnologias Utilizadas

- **Kotlin** - Linguagem de programação
- **ExoPlayer (Media3)** - Player de vídeo
- **Room Database** - Persistência de dados
- **Coroutines** - Programação assíncrona
- **LiveData** - Observação de dados
- **ViewModel** - Arquitetura MVVM
- **RecyclerView** - Listas eficientes
- **Material Design** - Interface moderna
- **OkHttp** - Requisições HTTP
- **Glide** - Carregamento de imagens

## Estrutura do Projeto

```
app/
├── src/main/
│   ├── java/com/myiptv/
│   │   ├── data/          # Modelos e DAOs
│   │   ├── parser/        # Parser M3U
│   │   ├── ui/            # Activities
│   │   ├── adapter/       # RecyclerView Adapters
│   │   └── viewmodel/     # ViewModels
│   ├── res/
│   │   ├── layout/        # XML Layouts
│   │   ├── values/        # Strings, Colors, Themes
│   │   └── drawable/      # Ícones e imagens
│   └── AndroidManifest.xml
```

## Funcionalidades Futuras

- [ ] EPG (Electronic Program Guide)
- [ ] Gravação de canais
- [ ] Suporte para VOD (Video on Demand)
- [ ] Séries e filmes
- [ ] Controle parental
- [ ] Tema escuro/claro
- [ ] Backup e restauração
- [ ] Chromecast support

## Licença

Este projeto é para fins educacionais. Use por sua própria conta e risco.

## Aviso Legal

Este aplicativo é apenas um player. Você é responsável pelo conteúdo que assiste. Certifique-se de ter os direitos necessários para acessar o conteúdo IPTV.
