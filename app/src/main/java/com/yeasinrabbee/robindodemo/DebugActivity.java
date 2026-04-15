package com.yeasinrabbee.robindodemo;

import android.app.Activity;

/* loaded from: classes.dex */
public class DebugActivity extends Activity {
    String[] exceptionType = {"StringIndexOutOfBoundsException", "IndexOutOfBoundsException", "ArithmeticException", "NumberFormatException", "ActivityNotFoundException"};
    String[] errMessage = {"Invalid string operation\n", "Invalid list operation\n", "Invalid arithmetical operation\n", "Invalid toNumber block operation\n", "Invalid intent operation"};

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r1.isEmpty() != false) goto L15;
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            r2 = 0
            super.onCreate(r8)
            android.content.Intent r0 = r7.getIntent()
            java.lang.String r1 = ""
            java.lang.String r1 = ""
            if (r0 == 0) goto L8f
            java.lang.String r3 = "error"
            java.lang.String r0 = r0.getStringExtra(r3)
            java.lang.String r3 = "\n"
            java.lang.String[] r3 = r0.split(r3)
        L1a:
            java.lang.String[] r4 = r7.exceptionType     // Catch: java.lang.Exception -> L8c
            int r4 = r4.length     // Catch: java.lang.Exception -> L8c
            if (r2 < r4) goto L44
        L1f:
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Exception -> L8c
            if (r2 == 0) goto L8f
        L25:
            android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder
            r1.<init>(r7)
            java.lang.String r2 = "An error occured"
            r1.setTitle(r2)
            r1.setMessage(r0)
            java.lang.String r0 = "End Application"
            com.arefin.rabindra.DebugActivity$1 r2 = new com.arefin.rabindra.DebugActivity$1
            r2.<init>()
            r1.setNeutralButton(r0, r2)
            android.app.AlertDialog r0 = r1.create()
            r0.show()
            return
        L44:
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Exception -> L8c
            java.lang.String[] r5 = r7.exceptionType     // Catch: java.lang.Exception -> L8c
            r5 = r5[r2]     // Catch: java.lang.Exception -> L8c
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Exception -> L8c
            if (r4 == 0) goto L89
            java.lang.String[] r4 = r7.errMessage     // Catch: java.lang.Exception -> L8c
            r1 = r4[r2]     // Catch: java.lang.Exception -> L8c
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Exception -> L8c
            java.lang.String[] r5 = r7.exceptionType     // Catch: java.lang.Exception -> L8c
            r5 = r5[r2]     // Catch: java.lang.Exception -> L8c
            int r4 = r4.indexOf(r5)     // Catch: java.lang.Exception -> L8c
            java.lang.String[] r5 = r7.exceptionType     // Catch: java.lang.Exception -> L8c
            r2 = r5[r2]     // Catch: java.lang.Exception -> L8c
            int r2 = r2.length()     // Catch: java.lang.Exception -> L8c
            int r2 = r2 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8c
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L8c
            r4.<init>(r5)     // Catch: java.lang.Exception -> L8c
            r5 = 0
            r5 = r3[r5]     // Catch: java.lang.Exception -> L8c
            r6 = 0
            r3 = r3[r6]     // Catch: java.lang.Exception -> L8c
            int r3 = r3.length()     // Catch: java.lang.Exception -> L8c
            java.lang.String r2 = r5.substring(r2, r3)     // Catch: java.lang.Exception -> L8c
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch: java.lang.Exception -> L8c
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L8c
            goto L1f
        L89:
            int r2 = r2 + 1
            goto L1a
        L8c:
            r0 = move-exception
            r0 = r1
            goto L25
        L8f:
            r0 = r1
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arefin.rabindra.DebugActivity.onCreate(android.os.Bundle):void");
    }
}
