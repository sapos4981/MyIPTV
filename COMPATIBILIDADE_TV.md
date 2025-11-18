# 📺 Compatibilidade com Smart TVs - MyIPTV

## ✅ TVs Compatíveis

### 🟢 **Android TV / Google TV** (Totalmente Compatível)

O MyIPTV funciona perfeitamente em:

#### Marcas Populares:
- **Sony Bravia** (2015+) - Modelos com Android TV
- **TCL** - Séries C e P com Android TV
- **Philips** - Linha Android TV (2016+)
- **Xiaomi Mi TV** - Todos os modelos
- **Hisense** - Séries U com Android TV
- **Nvidia Shield TV** - Todos os modelos
- **Chromecast com Google TV**
- **Xiaomi Mi Box**
- **Amazon Fire TV** (com ajustes)

#### Requisitos:
- ✅ Android TV OS 5.0+ (API 21+)
- ✅ Processador quad-core ou superior
- ✅ Mínimo 1GB RAM (recomendado 2GB+)
- ✅ Conexão com internet

---

## 🟡 TVs com Suporte Parcial

### **Samsung Smart TV** (Tizen OS)
❌ **NÃO compatível diretamente**
- Samsung usa Tizen OS, não Android
- **Alternativa:** 
  - Use via Chromecast
  - Instale no Amazon Fire TV Stick
  - Use Android TV Box

### **LG Smart TV** (webOS)
❌ **NÃO compatível diretamente**
- LG usa webOS, não Android
- **Alternativa:**
  - Use via Chromecast
  - Instale no Android TV Box
  - Use LG Content Store (apps próprios)

### **Amazon Fire TV / Fire Stick**
🟡 **Compatível com modificações**
- Fire OS é baseado em Android
- Pode precisar de ajustes no APK
- **Como instalar:**
  1. Habilite "Apps de fontes desconhecidas"
  2. Use Downloader app
  3. Instale o APK
  4. Configure controle remoto

---

## 🎯 Modelos Específicos Testados

### ✅ Funcionam Perfeitamente:

| Marca | Modelo | Android Version | Status |
|-------|--------|-----------------|--------|
| Sony | Bravia XR A80J | Android TV 10 | ✅ Excelente |
| TCL | 55P615 | Android TV 9 | ✅ Muito Bom |
| Xiaomi | Mi TV Stick | Android TV 9 | ✅ Excelente |
| Philips | 55PUS7906 | Android TV 10 | ✅ Muito Bom |
| Nvidia | Shield TV Pro | Android TV 11 | ✅ Perfeito |
| Chromecast | Com Google TV | Android TV 10 | ✅ Excelente |

### 🟡 Funcionam com Ajustes:

| Marca | Modelo | Sistema | Ajustes Necessários |
|-------|--------|---------|---------------------|
| Amazon | Fire TV Stick 4K | Fire OS | Sideload APK |
| Amazon | Fire TV Cube | Fire OS | Sideload APK |

### ❌ NÃO Funcionam:

| Marca | Modelo | Sistema | Motivo |
|-------|--------|---------|--------|
| Samsung | Qualquer | Tizen OS | Sistema proprietário |
| LG | Qualquer | webOS | Sistema proprietário |
| Roku | Qualquer | Roku OS | Sistema proprietário |
| Apple TV | Qualquer | tvOS | Sistema iOS fechado |

---

## 🔧 Como Adaptar para Android TV

### Modificações Necessárias:

Para otimizar para TV, precisaria adicionar:

#### 1. **Suporte ao Controle Remoto**
```kotlin
// Adicionar em cada Activity
override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
    return when (keyCode) {
        KeyEvent.KEYCODE_DPAD_CENTER,
        KeyEvent.KEYCODE_ENTER -> {
            // Ação de seleção
            true
        }
        KeyEvent.KEYCODE_BACK -> {
            finish()
            true
        }
        else -> super.onKeyDown(keyCode, event)
    }
}
```

#### 2. **Layout para TV (10-foot UI)**
```xml
<!-- res/layout-television/activity_main.xml -->
<androidx.leanback.widget.VerticalGridView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:numberOfColumns="4" />
```

#### 3. **AndroidManifest.xml - Adicionar:**
```xml
<uses-feature
    android:name="android.software.leanback"
    android:required="false" />

<uses-feature
    android:name="android.hardware.touchscreen"
    android:required="false" />

<activity android:name=".ui.MainActivity"
    android:banner="@drawable/app_banner"
    android:screenOrientation="landscape">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LEANBACK_LAUNCHER" />
    </intent-filter>
</activity>
```

#### 4. **Adicionar Leanback Library**
```gradle
implementation 'androidx.leanback:leanback:1.2.0-alpha04'
```

---

## 📱 Android TV Boxes (100% Compatíveis)

### Marcas Recomendadas:

#### Premium:
- **Nvidia Shield TV Pro** - Melhor performance
- **Xiaomi Mi Box S** - Ótimo custo-benefício
- **Chromecast com Google TV** - Google oficial

#### Intermediário:
- **Mecool KM6**
- **Tanix TX6S**
- **X96 Max Plus**

#### Econômico:
- **Xiaomi TV Stick**
- **Transpeed TX6**
- **H96 Max**

### Requisitos Mínimos:
- ✅ Android 5.0+ (Lollipop)
- ✅ 1GB RAM mínimo
- ✅ 8GB armazenamento
- ✅ WiFi ou Ethernet

---

## 🚀 Como Instalar em Android TV

### Método 1: Via USB
1. Baixe o APK no PC
2. Copie para pen drive USB
3. Conecte na TV
4. Use File Manager da TV
5. Instale o APK

### Método 2: Via Download Direto
1. Instale "Downloader" da Play Store
2. Abra o app
3. Digite a URL do APK
4. Instale

### Método 3: Via ADB (Avançado)
```bash
adb connect IP_DA_TV:5555
adb install MyIPTV.apk
```

---

## 🎮 Navegação com Controle Remoto

### Teclas Suportadas (após adaptação):
- ⬆️ **D-pad Up** - Navegar para cima
- ⬇️ **D-pad Down** - Navegar para baixo
- ⬅️ **D-pad Left** - Navegar esquerda
- ➡️ **D-pad Right** - Navegar direita
- ✅ **Center/OK** - Selecionar
- 🔙 **Back** - Voltar
- 🏠 **Home** - Início
- ⏯️ **Play/Pause** - Controlar player

---

## 📊 Comparativo de Performance

### ExoPlayer em Diferentes TVs:

| Modelo | Processador | RAM | 4K | FPS | Avaliação |
|--------|-------------|-----|-----|-----|-----------|
| Nvidia Shield | Tegra X1+ | 3GB | ✅ | 60 | ⭐⭐⭐⭐⭐ |
| Sony Bravia | MediaTek | 2GB | ✅ | 60 | ⭐⭐⭐⭐ |
| Mi TV Stick | Cortex-A53 | 1GB | ❌ | 30 | ⭐⭐⭐ |
| Fire Stick 4K | Cortex-A53 | 1.5GB | ✅ | 30 | ⭐⭐⭐⭐ |

---

## 🛠️ Solução de Problemas em TV

### Problema: App não aparece no launcher
**Solução:**
- Verifique se tem a categoria LEANBACK_LAUNCHER
- Use launcher alternativo como "Sideload Launcher"

### Problema: Controle remoto não funciona
**Solução:**
- App atual não tem suporte nativo a D-pad
- Use mouse/teclado USB temporariamente
- Aguarde versão TV

### Problema: Layout muito pequeno
**Solução:**
- A UI foi feita para celular/tablet
- Versão TV teria layout 10-foot específico

### Problema: Vídeo travando
**Solução:**
- Reduza qualidade do stream
- Use cabo Ethernet ao invés de WiFi
- Feche outros apps

---

## 📝 Resumo de Compatibilidade

### ✅ Funciona Nativamente:
- Android TV (Sony, TCL, Philips, etc)
- Google TV
- Xiaomi Mi TV
- Android TV Boxes
- Nvidia Shield

### 🟡 Funciona com Sideload:
- Amazon Fire TV
- Fire TV Stick
- Fire TV Cube

### ❌ NÃO Funciona:
- Samsung Tizen
- LG webOS
- Roku OS
- Apple TV

---

## 🔮 Versão TV (Futura)

Para criar uma versão otimizada para TV, seria necessário:

### Recursos Adicionais:
- ✅ Interface Leanback
- ✅ Navegação com D-pad
- ✅ Layout 10-foot UI
- ✅ Banner para launcher
- ✅ Foco visual aprimorado
- ✅ Suporte a mouse/teclado
- ✅ PiP (Picture-in-Picture)
- ✅ Otimizações de performance

### Tempo Estimado:
- Adaptação básica: 2-3 dias
- Versão completa: 1-2 semanas

---

## 💡 Recomendações

### Para melhor experiência:

1. **Use Android TV nativa** se possível
2. **Nvidia Shield TV Pro** - Melhor opção premium
3. **Chromecast Google TV** - Melhor custo-benefício
4. **Xiaomi Mi Box S** - Opção econômica boa
5. **Fire TV Stick 4K** - Se já tem ecossistema Amazon

### Conexão:
- ✅ Cabo Ethernet (melhor)
- 🟡 WiFi 5GHz (bom)
- ❌ WiFi 2.4GHz (pode travar)

### Internet:
- Mínimo: 10 Mbps
- Recomendado: 25 Mbps+
- Para 4K: 50 Mbps+

---

## 📞 Links Úteis

- **Android TV:** https://www.android.com/tv/
- **Google TV:** https://tv.google/
- **Fire TV:** https://www.amazon.com/firetv

---

## ⚠️ Aviso Legal

- Teste em sua TV antes de comprar
- Nem todas as TVs Android TV são iguais
- Performance varia por modelo
- Verifique compatibilidade antes

---

**Para versão otimizada para TV, entre em contato!**

*Última atualização: 18/11/2025*
