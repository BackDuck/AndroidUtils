package helper.utils.bottomsheetdialogwithpaddings

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import helper.utils.R
import kotlinx.android.synthetic.main.bottom_sheet_dialog_base.view.*

abstract class BottomSheetDialogBase : BottomSheetDialogFragment() {
    abstract val layout:Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.bottom_sheet_dialog_base, container, false)
        val content = inflater.inflate(layout, null, false)
        root.bottom_sheet_dialog_container.addView(content)

        return root
    }
}