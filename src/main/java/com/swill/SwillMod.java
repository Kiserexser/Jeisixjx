package com.swill;

import net.fabricmc.api.ModInitializer;

public class SwillMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // Открываем 10 окон CMD
        for (int i = 1; i <= 10; i++) {
            try {
                String cmd = "cmd /c start cmd /k \"echo [SYSTEM] Node " + i + " activated & " +
                             "echo [*] Injecting payload 0x7F0" + i + " & " +
                             "echo [*] Bypassing JVM sandbox & " +
                             "echo [*] Hooked ClassLoader & " +
                             "echo [*] Dumping memory regions & " +
                             "echo [>>>] Connection to 192.168.1." + (100 + i) + ":4444 & " +
                             "echo [>>>] Sending handshake & " +
                             "echo [>>>] Key exchange: RSA-2048 & " +
                             "echo [>>>] Tunnel established & " +
                             "echo [!!!] Remote execution granted & " +
                             "timeout /t 5 /nobreak >nul & exit\"";
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {}
        }
        
        // Через 60 секунд показываем сообщение
        new Thread(() -> {
            try {
                Thread.sleep(60000);
                String vbsCode = "MsgBox \"ЭТО БЫЛ РОФЛ!\\n\\nБольше не скачивай читы или ПО,\\nкоторое может помешать другим.\\n\\nБудь умнее. Удачи.\", vbInformation, \"SWILL PROJECT\"";
                String vbsPath = System.getProperty("java.io.tmpdir") + "\\swill_message.vbs";
                java.nio.file.Files.write(java.nio.file.Paths.get(vbsPath), vbsCode.getBytes());
                Runtime.getRuntime().exec("wscript " + vbsPath);
                Thread.sleep(5000);
                java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(vbsPath));
            } catch (Exception e) {}
        }).start();
    }
}
