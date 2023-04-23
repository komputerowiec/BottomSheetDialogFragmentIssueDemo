package com.example.bsdfd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DemoBottomSheetDialogFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dialogView = inflater.inflate(R.layout.bottm_sheet_dialog_fragment, container, false)
        dialogView.findViewById<ComposeView>(R.id.compose_view).setContent {
            var textFieldValue by remember {
                mutableStateOf(TextFieldValue(text = "", selection = TextRange.Zero))
            }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textFieldValue,
                onValueChange = { newValue -> textFieldValue = TextFieldValue(text = newValue.text, selection = newValue.selection) }
            )
        }
        return dialogView
    }
}