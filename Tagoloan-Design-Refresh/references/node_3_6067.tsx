const assetPathPrefix = "https://www.figma.com/api/mcp/asset/3440a8d6-06eb-48f5-9a6e-e6f3ddb0e8f3";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconLock = `${assetPathPrefix}/614c6.svg`;
const imgIconBike = `${assetPathPrefix}/3492d.svg`;
const imgIconFlash = `${assetPathPrefix}/48a31.svg`;
const imgIconUp = `${assetPathPrefix}/ff299.svg`;
const imgIconCamera = `${assetPathPrefix}/40e12.svg`;

export default function RiderNotification() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:6067" data-name="RIDER NOTIFICATION">
      <div className="absolute bg-gradient-to-b content-stretch flex flex-col from-[#fbf9f1] h-[844px] items-start left-0 overflow-clip to-[#ffecb8] top-0 w-[390px]" data-node-id="136:91" data-name="Lock screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="136:92" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="136:93" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="136:94">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="136:95" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="136:96" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="136:98" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="136:100" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex flex-col gap-[4px] items-center overflow-clip py-[24px] relative shrink-0 w-full" data-node-id="136:102" data-name="Clock">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[6px] items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="136:103" data-name="Container">
            <div className="relative shrink-0 size-[12px]" data-node-id="136:104" data-name="icon/lock">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconLock} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[11px] whitespace-nowrap" data-node-id="136:107">
              Locked
            </p>
          </div>
          <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Light'] font-light leading-[1.4] min-w-full relative shrink-0 text-[#18181f] text-[72px] text-center w-[min-content]" data-node-id="136:108">
            9:41
          </p>
          <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] text-center w-[min-content]" data-node-id="136:109">
            Wednesday, Oct 24 · 28°C
          </p>
        </div>
        <div className="content-stretch flex flex-col gap-[12px] items-start overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="136:110" data-name="Notifications">
          <div className="[word-break:break-word] content-stretch flex items-center leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:111" data-name="Container">
            <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold min-w-px relative text-[#6b6b73] text-[13px]" data-node-id="136:112">
              Notifications
            </p>
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#a3a3ab] text-[12px] whitespace-nowrap" data-node-id="136:113">
              3 new
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[8px] items-start overflow-clip p-[16px] relative rounded-[20px] shadow-[0px_4px_16px_0px_rgba(23,23,31,0.06)] shrink-0 w-full" data-node-id="136:114" data-name="Notification – New Pasugo request · ₱65.00">
            <div className="content-stretch flex gap-[8px] items-center overflow-clip relative shrink-0 w-full" data-node-id="136:115" data-name="Container">
              <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[6px] shrink-0 size-[22px]" data-node-id="136:116" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="136:117" data-name="icon/bike">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBike} />
                </div>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:122">
                Tagoloan Xpress
              </p>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#a3a3ab] text-[12px]" data-node-id="136:123">
                · Now
              </p>
              <div className="bg-[#fff7e0] content-stretch flex items-center overflow-clip px-[8px] py-[2px] relative rounded-[999px] shrink-0" data-node-id="136:124" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b4e00] text-[11px] whitespace-nowrap" data-node-id="136:125">
                  Urgent
                </p>
              </div>
            </div>
            <div className="[word-break:break-word] content-stretch flex flex-col gap-[2px] items-start leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:126" data-name="Container">
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="136:127">
                New Pasugo request · ₱65.00
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="136:128">
                New errand in Poblacion, 2.1 km away.
              </p>
            </div>
            <div className="content-stretch cursor-pointer flex gap-[8px] items-start overflow-clip relative shrink-0 w-full" data-node-id="136:129" data-name="Container">
              <a className="bg-[#febc20] content-stretch flex flex-[1_0_0] items-center justify-center min-w-px overflow-clip px-[14px] py-[10px] relative rounded-[12px]" data-node-id="136:130" data-name="Action – View request">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#18181f] text-[13px] text-left whitespace-nowrap" data-node-id="136:131">
                  View request
                </p>
              </a>
              <a className="bg-[#f3f1ea] content-stretch flex flex-[1_0_0] items-center justify-center min-w-px overflow-clip px-[14px] py-[10px] relative rounded-[12px]" data-node-id="136:133" data-name="Action – Log in">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#18181f] text-[13px] text-left whitespace-nowrap" data-node-id="136:134">
                  Log in
                </p>
              </a>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[8px] items-start overflow-clip p-[16px] relative rounded-[20px] shadow-[0px_4px_16px_0px_rgba(23,23,31,0.06)] shrink-0 w-full" data-node-id="136:136" data-name="Notification – Proof of handover needed">
            <div className="content-stretch flex gap-[8px] items-center overflow-clip relative shrink-0 w-full" data-node-id="136:137" data-name="Container">
              <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[6px] shrink-0 size-[22px]" data-node-id="136:138" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="136:139" data-name="icon/bike">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBike} />
                </div>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:144">
                Tagoloan Xpress
              </p>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#a3a3ab] text-[12px]" data-node-id="136:145">
                · 15m
              </p>
              <div className="bg-[#f3f1ea] content-stretch flex items-center overflow-clip px-[8px] py-[2px] relative rounded-[999px] shrink-0" data-node-id="136:146" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[11px] whitespace-nowrap" data-node-id="136:147">
                  Pending
                </p>
              </div>
            </div>
            <div className="[word-break:break-word] content-stretch flex flex-col gap-[2px] items-start leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:148" data-name="Container">
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="136:149">
                Proof of handover needed
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="136:150">
                Upload a handover photo for #TGX-8921.
              </p>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[8px] items-start overflow-clip p-[16px] relative rounded-[20px] shadow-[0px_4px_16px_0px_rgba(23,23,31,0.06)] shrink-0 w-full" data-node-id="136:151" data-name="Notification – Road advisory">
            <div className="content-stretch flex gap-[8px] items-center overflow-clip relative shrink-0 w-full" data-node-id="136:152" data-name="Container">
              <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[6px] shrink-0 size-[22px]" data-node-id="136:153" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="136:154" data-name="icon/bike">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBike} />
                </div>
              </div>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:159">
                Tagoloan Xpress
              </p>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.4] min-w-px relative text-[#a3a3ab] text-[12px]" data-node-id="136:160">
                · 1h
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex flex-col gap-[2px] items-start leading-[1.4] overflow-clip relative shrink-0 w-full" data-node-id="136:161" data-name="Container">
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="136:162">
                Road advisory
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="136:163">
                Road repair near Tagoloan Plaza. Use alternate routes.
              </p>
            </div>
          </div>
        </div>
        <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="136:164" data-name="Flexible space" />
        <div className="content-stretch flex items-center overflow-clip px-[32px] py-[16px] relative shrink-0 w-full" data-node-id="136:165" data-name="Lock actions">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-center justify-center overflow-clip relative rounded-[24px] shrink-0 size-[48px]" data-node-id="136:166" data-name="Container">
            <div className="relative shrink-0 size-[20px]" data-node-id="136:167" data-name="icon/flash">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconFlash} />
            </div>
          </div>
          <div className="content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-center min-w-px overflow-clip relative" data-node-id="136:170" data-name="Container">
            <div className="relative shrink-0 size-[16px]" data-node-id="136:171" data-name="icon/up">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconUp} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.4] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="136:173">
              Swipe up to unlock
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-center justify-center overflow-clip relative rounded-[24px] shrink-0 size-[48px]" data-node-id="136:174" data-name="Container">
            <div className="relative shrink-0 size-[20px]" data-node-id="136:175" data-name="icon/camera">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCamera} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex items-start justify-center overflow-clip py-[10px] relative shrink-0 w-full" data-node-id="136:178" data-name="Container">
          <div className="bg-[#18181f] h-[4px] relative rounded-[2px] shrink-0 w-[120px]" data-node-id="136:179" data-name="Rectangle" />
        </div>
      </div>
    </div>
  );
}
