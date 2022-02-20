package com.spbkit.kurchavov204.lab04twoactivites

import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ExitButtonHandler(private val ctx: AppCompatActivity): View.OnClickListener {
    override fun onClick(p0: View?) {
            val builder = AlertDialog.Builder(ctx)
            builder.create()  // Курчавов Алексей 204 группа СПБКИТ
            builder.setTitle(ctx.getString(R.string.exit))
            builder.setIcon(R.drawable.dialog_img)
            builder.setMessage(ctx.getString(R.string.sure_exit))
            builder.setCancelable(true)  // Курчавов Алексей 204 группа СПБКИТ
            builder.setPositiveButton(ctx.getString(R.string.exit)) { _, _ ->
                ctx.finishAffinity()
            }  // Курчавов Алексей 204 группа СПБКИТ
            builder.setNegativeButton(ctx.getString(R.string.cancel)) { _, _ -> }
            builder.show()
    }
}  // Курчавов Алексей 204 группа СПБКИТ