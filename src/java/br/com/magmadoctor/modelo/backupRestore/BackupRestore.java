package br.com.magmadoctor.modelo.backupRestore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dirceu Junior
 */
public class BackupRestore {

    public void realizaBackup() throws IOException, InterruptedException, ParseException {

        final List<String> comandos = new ArrayList<>();

        //comandos.add("C:\\Program Files (x86)\\PostgreSQL\\8.4\\bin\\pg_dump.exe");   
        //comandos.add("C:\\Program Files\\PostgresPlus\\8.4SS\\bin\\pg_dump.exe");   
        comandos.add("C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe");    // esse é meu caminho    

        comandos.add("-i");
        comandos.add("-h");
        comandos.add("localhost");     //ou  comandos.add("192.168.0.1");   
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("postgres");
        comandos.add("-F");
        comandos.add("c");
        comandos.add("-b");
        comandos.add("-v");
        comandos.add("-f");
        SimpleDateFormat formatData = new SimpleDateFormat("ddMMyyyy-HHmmss");
        Date horario = Calendar.getInstance().getTime();
        String dataAtual = "c:\\clinicaBackup-" + formatData.format(horario) + ".backup";
        comandos.add(dataAtual);   
        comandos.add("clinica");

        ProcessBuilder pb = new ProcessBuilder(comandos);

        pb.environment().put("PGPASSWORD", "postgres");      //Somente coloque sua senha           

        try {
            final Process process = pb.start();
            final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }
            r.close();
            process.waitFor();
            process.destroy();
            JOptionPane.showMessageDialog(null, "backup realizado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    public void realizaRestore() throws IOException, InterruptedException {

        final List<String> comandos = new ArrayList<>();

        comandos.add("C:\\Arquivos de programas\\PostgreSQL\\9.1\\bin\\pg_restore.exe"); //testado no windows xp

        comandos.add("-i");
        comandos.add("-h");
        comandos.add("localhost");    //ou   comandos.add("192.168.0.1"); 
        comandos.add("-p");
        comandos.add("5432");
        comandos.add("-U");
        comandos.add("postgres");
        comandos.add("-d");
        comandos.add("clinica");
        comandos.add("-v");
        comandos.add("c:\\clinicaBackup.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
        ProcessBuilder pb = new ProcessBuilder(comandos);

        pb.environment().put("PGPASSWORD", "postgres");     //Somente coloque sua senha         

        try {
            final Process process = pb.start();
            final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }
            r.close();
            process.waitFor();
            process.destroy();
            JOptionPane.showMessageDialog(null, "Restore realizado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    public void realizarBackupSQL() throws IOException, InterruptedException {
//        try {
//            ProcessBuilder pb;
//            Process p;
//            pb = new ProcessBuilder("C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe",
//                    "-i", "-h", "localhost", "-p", "5432", "-U", "postgres",
//                    "-F", "c", "-b", "-v", "-f", "C:\\TesteBKP.sql", "clinica");
//            pb.environment().put("PGPASSWORD", "postgres");
//            pb.redirectErrorStream(true);
//            p = pb.start();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }

    }

}
