package com.sriyank.globochat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.MultiSelectListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat


class AccountSettingsFragment : PreferenceFragmentCompat() {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        val publicInfoPref = MultiSelectListPreference(context)
        publicInfoPref.entries = resources.getStringArray(R.array.entries_public_info)
        publicInfoPref.entryValues = resources.getStringArray(R.array.values_public_info)
        publicInfoPref.key = getString(R.string.key_public_info)
        publicInfoPref.title = getString(R.string.title_public_info)
        publicInfoPref.isIconSpaceReserved = false

        val logOutPref = Preference(context)
        logOutPref.key = getString(R.string.key_log_out)
        logOutPref.title = getString(R.string.title_log_out)
        logOutPref.isIconSpaceReserved = false

        val deleteAccPref = Preference(context)
        deleteAccPref.key = getString(R.string.key_delete_account)
        deleteAccPref.summary = getString(R.string.summary_delete_account)
        deleteAccPref.title = getString(R.string.title_delete_account)
        deleteAccPref.icon = ResourcesCompat.getDrawable(resources, android.R.drawable.ic_menu_delete, null)


        val privacyCategory = PreferenceCategory(context)
        privacyCategory.title = getString(R.string.title_privacy)
        privacyCategory.isIconSpaceReserved = false

        val securityCategory = PreferenceCategory(context)
        securityCategory.title = getString(R.string.title_security)
        securityCategory.isIconSpaceReserved = false

        val prefScreen = preferenceManager.createPreferenceScreen(context)


        prefScreen.addPreference(privacyCategory)
        prefScreen.addPreference(securityCategory)

        privacyCategory.addPreference(publicInfoPref)

        securityCategory.addPreference(logOutPref)
        securityCategory.addPreference(deleteAccPref)

        preferenceScreen = prefScreen



    }
}
