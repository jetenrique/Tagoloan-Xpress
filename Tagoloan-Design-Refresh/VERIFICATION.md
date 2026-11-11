# Preparation checks

- 38 Figma frame code references and screenshots retrieved on 2026-11-11.
- 197 actual static Figma assets downloaded; zero failed downloads.
- 197 Android PNGs generated from original assets; all image files decode.
- Four static Plus Jakarta Sans weights and OFL license included.
- Five Kotlin files pass tree-sitter Kotlin syntax parsing.
- Native file public destination callbacks checked against baseline source.
- Source signatures/data hashes match GitHub commit 6520406.
- Bundle extraction and content hashes verified separately before delivery.

NOT VERIFIED: Kotlin type checking, Android compilation, runtime navigation,
emulator regressions or visual comparison of the implemented app. The configured
Gradle download fails with Network is unreachable in this environment.

Only login screens, customer Home and shared primitives are supplied as native
presentation source. Copilot must finish adapting the other screen layouts from
the provided per-frame visual references before treating this task as complete.
